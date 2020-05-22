StringBuilder s = new StringBuilder();
 while ((message = bufferedReader.readLine()) != null) {
     s.append(message+"\n");
 }

 JOptionPane.showMessageDialog(null, s);