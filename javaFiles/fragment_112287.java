String ques = "<html><body><b>-----------------Menu Options--------------</b><br/>"
            + "Here you need to enter a number between 1 and 6 according your choice.<br/>"
            + "----------------------------------------------------------------------------<br/>"
            + "1.Search for a particular student.<br/>"
            + "2.Show students names, marks and grades.<br/>"
            + "3.Display passes.<br/>"
            + "4.Display failures.<br/>"
            + "5.Show statistics.<br/>"
            + "6.Exit.<br/>"
            + "Enter you choice<br/></body></html>";
     int opt = Integer.parseInt(JOptionPane.showInputDialog(ques));
     System.out.println(opt);