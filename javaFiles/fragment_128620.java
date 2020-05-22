String beginning= "beginning of line";
    String emptySpaces = new String(new char[begining.length()]).replace("\0", " "); // Create empty spaces with the same length of the begining sentence
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < model.getRowCount(); i++) {
        final String first = (i == 0) ? begining : emptySpaces;
        builder.append(first).append(" [").append(jTable1.getValueAt(i,0).toString()).append("]");
        final String last = (i == model.getRowCount() - 1) ? " end of line" : ",\n";
        builder.append(last);
    }
    System.out.println(builder.toString());