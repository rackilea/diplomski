String text = listOfFiles[j].getName();
String txsp[] = text.split("-");
prepStmt.setString(1, txsp[0]);
prepStmt.setString(2, txsp[1]);
prepStmt.setString(3, txsp[2]);
prepStmt.setString(4, txsp[3]);
prepStmt.setString(5, txsp[4]);
prepStmt.setString(6, txsp[5]);
prepStmt.execute(); // executa o INSERT

myTextArea.append(text + "\n");