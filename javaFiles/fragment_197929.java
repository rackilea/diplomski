StringBuilder sb = new StringBuilder();
for (int i = 0; i < something.length; i++) {
  sb.append(/* something */ + "\n");
}
// ... etc...

JOptionPane.showMessage(null, sb.toString());