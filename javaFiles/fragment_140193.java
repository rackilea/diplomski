for (int j=0; j < table.getColumnCount(); j++){
      String value = (String)table.getModel().getValueAt(i, j);
      if((value == null || "null".equals(value)){
          value = "";
      }
      bw.write(value+";"); //write the contents to the file
 }