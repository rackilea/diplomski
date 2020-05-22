String h_url = "http://example.com/index.html";
                        String h_text = replacement;

                        // Creates the link as an external relationship
                        String id = r.getDocument().getPackagePart()
                                .addExternalRelationship(h_url, XWPFRelation.HYPERLINK.getRelation()).getId();

                        // Binds the link to the relationship
                        CTHyperlink link = r.getParagraph().getCTP().addNewHyperlink();
                        link.setId(id);

                        // Creates the linked text
                        CTText linked_text = CTText.Factory.newInstance();
                        linked_text.setStringValue(h_text);

                        // Creates a XML wordprocessing wrapper for Run
                        // The magic is here
                        CTR ctr = r.getCTR();
                        ctr.setTArray(new CTText[] { linked_text });

                        // Stylizing
                        CTRPr rpr_c = ctr.addNewRPr();
                        CTColor color = CTColor.Factory.newInstance();
                        color.setVal("0000FF");
                        rpr_c.setColor(color);

                        CTRPr rpr_u = ctr.addNewRPr();
                        rpr_u.addNewU().setVal(STUnderline.SINGLE);