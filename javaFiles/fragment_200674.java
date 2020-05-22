try {   
        HtmlCleaner hc = new HtmlCleaner();
        CleanerProperties cp = hc.getProperties();
        cp.setAllowHtmlInsideAttributes(true);
        cp.setAllowMultiWordAttributes(true);
        cp.setRecognizeUnicodeChars(true);
        cp.setOmitComments(true);

        String loc = sp.getString( Constants.pref_locatie      , "" );
        String per = sp.getString( Constants.pref_persoon      , "" );
        String oob = sp.getString( Constants.pref_onderofboven , "" );

        int counteruurmax;
        int[] pauze;
        if (oob.contains("onder")){
            pauze = Constants.pauzeo;
        } else if (oob.contains("boven")) {
            pauze = Constants.pauzeb;
        } else {
            return false;
        }

        String url = "";
        if (loc.contains("lochem")) {
            url += Constants.RoosterLochem;
            url += t.getDatum();
            url += "/";
            url += per;
            counteruurmax = 11;
        } else if (loc.contains("herenlaan")) {
            url += Constants.RoosterHerenlaan;
            url += per;
            counteruurmax = 13;
        } else if (loc.contains("beukenlaan")) {
            url += Constants.RoosterBeukenlaan;
            url += per;
            counteruurmax = 11;
        } else {
            return false;
        }

        String htmlcode = t.getHtml(url);
        TagNode html = hc.clean(htmlcode);
        Document doc = new DomSerializer(cp, true).createDOM(html);
        XPath xp = XPathFactory.newInstance().newXPath();
        NodeList nl = (NodeList) xp.evaluate(Constants.XPathRooster, doc, XPathConstants.NODESET);

        int counteruur = 1;
        int counterdag = 1;
        int decreaser  = 0;
        Boolean isPauze = false;
        RoosterItems RItems = new RoosterItems();
        RoosterItem  RItem  = null;
        for (int i = 0; i < nl.getLength(); i++){

            if ((counteruur == pauze[0]) || (counteruur == pauze[1]) || (counteruur == pauze[2])) {
                isPauze = true;
                decreaser++;
            }

            if (!isPauze) {
                RItem = new RoosterItem();
                switch (counterdag){
                case 1:
                    RItem.setDag("ma");
                    break;
                case 2:
                    RItem.setDag("di");
                    break;
                case 3:
                    RItem.setDag("wo");
                    break;
                case 4:
                    RItem.setDag("do");
                    break;
                case 5:
                    RItem.setDag("vr");
                    break;
                }

                Node n = nl.item(i);
                String content = n.getTextContent();
                if (content.length() > 1) {
                    RItem.setUur(""+(counteruur-decreaser));
                    NodeList t1 = n.getChildNodes();
                    NodeList t2 = t1.item(0).getChildNodes();
                    NodeList t3 = t2.item(0).getChildNodes();
                    for (int j = 0; j < t3.getLength(); j++) {
                        Node temp = t3.item(j);
                        if (t3.getLength() == 3) {
                            switch (j) {
                            case 0:
                                RItem.setLes(""+temp.getTextContent());
                                break;
                            case 1:
                                RItem.setLokaal(""+temp.getTextContent());
                                break;
                            case 2:
                                RItem.setDocent(""+temp.getTextContent());
                                break;
                            default:
                                return false;
                            }
                        } else if (t3.getLength() == 4) {
                            switch (j) {
                            case 0:
                                break;
                            case 1:
                                RItem.setLes("tts. " + temp.getTextContent());
                                break;
                            case 2:
                                RItem.setLokaal(""+temp.getTextContent());
                                break;
                            case 3:
                                RItem.setDocent(""+temp.getTextContent());
                                break;
                            default:
                                return false;
                            }
                        } else if (t3.getLength() == 1) {
                            RItem.setLes(""+temp.getTextContent());
                        } else {
                            return false;
                        }
                    }
                } else {
                    RItem.setUur("" + (counteruur-decreaser));
                    RItem.setLokaal("Vrij");
                }
                RItems.add(RItem);
            }
            if (counteruur == counteruurmax) { counteruur = 0; counterdag++; decreaser = 0;}
            counteruur++;
            isPauze = false;
        }

        if (RItems.size() > 0) {
            mSQL = new RoosterSQLAdapter(mContext);
            mSQL.openToWrite();
            mSQL.deleteAll();
            for (int j = 0; j < RItems.size(); j++) {
                RoosterItem insert = RItems.get(j);
                mSQL.insert(insert.getDag(), insert.getUur(), insert.getLes(), insert.getLokaal(), insert.getDocent());
            }
            if (mSQL != null) mSQL.close();
        }
        return true;
    } catch (ParserConfigurationException e) {
        e.printStackTrace();
        return false;
    } catch (XPathExpressionException e) {
        e.printStackTrace();
        return false;
    }