StringBuilder sb = new StringBuilder();
    sb.append("<html>");

    String [][] gridPlayer = new String [6][6];
    Scanner kb = new Scanner (System.in);

    String [] rows = {"A", "B", "C", "D", "E", "F", "G", "H"};

    for (int i = 0; i < 6; i++){
        for (int j = 0; j < 6; j++){

            gridPlayer[i][j] = " ~ ";
        }
    }
    sb.append("&nbsp&nbsp");
    for (int i = 0; i < 6; i++){
        sb.append(" " + rows[i] + " ");
    }
    sb.append("<br>");
    for (int i = 0; i < 6; i++){
        sb.append(" " + i);
        for (int j = 0; j < 6; j++){
            sb.append(gridPlayer[i][j]);
        }

        sb.append("<br>");

    }
    sb.append("</html>");

    JOptionPane.showMessageDialog(null, new JLabel(sb.toString()));