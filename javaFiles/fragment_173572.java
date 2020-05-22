while (sc.hasNext()) {
        String s = sc.next();
        if (s.equals(strSearchString)) {
           searchOutLabel.setText("Yes");
           sc.close();
           return;
        }
     }
     searchOutLabel.setText("Non!");         
     sc.close();