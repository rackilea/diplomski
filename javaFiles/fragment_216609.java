spinnerrg = new Spinner(con);
            //RadioGroup rg = new RadioGroup(con);
            NodeList rl = child.getChildNodes();
            Vector<String> radioadapt = new Vector<String>();
            for(int j=0;j<rl.getLength();j++) {
                Element[] dumrad = new Element[rl.getLength()];
                Node dum = rl.item(j);
                if(dum instanceof Element) {
                    //RadioButton rb = new RadioButton(con);
                    dumrad[j] = (Element) dum;
                    //rb.setHint(dumrad[j].getAttribute("value"));
                    radioadapt.add(dumrad[j].getAttribute("value"));
                    //rg.addView(rb);

                }
            }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(con, android.R.layout.simple_spinner_item, radioadapt);

            spinnerrg.setAdapter(adapter);
            TextView radioText = new TextView(con);
            radioText.setText(child.getAttribute("label"));
            //spinnerrg.setTag(child.getAttribute("id"));
            contList.add(radioText);
            contList.add(spinnerrg);