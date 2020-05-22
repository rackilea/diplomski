if(!p.getName().equals("classe")) {
            TextField l = new TextField();
            l.setUserData(p.getName()); //Store the attribute name in the TextField
            lab.setText(p.getName());
            gp.add(l, 1, i);

        }else {
            ComboBox<String> cb = new ComboBox<String>();
            cb.setUserData(p.getName()); //Store the attribute name in the ComboBox
            cb.getItems().addAll("1Bi","2Bi","3Bi");
            gp.add(cb, 1, i);
        }