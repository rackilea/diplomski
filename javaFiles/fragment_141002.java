//Dont put list to JTextArea.You can put data into directly

String first = rows.getString("FirstName");
String last = rows.getString("LastName");
String middleInitial = rows.getString("MiddleInitial");


JTextArea txaDetails=new JTextArea();
txaDetails.append("\n"+first +last +middleInitial +"\n");
txaDetails.setCaretPosition(txaDetails.getDocument().getLength());