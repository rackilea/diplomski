JTextArea tArea = new JTextArea(lineholder.length, 50);
  tArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 10));
  tArea.setText(sb.toString());
  JScrollPane scrollPane = new JScrollPane(tArea);
  //!! JOptionPane.showMessageDialog(null, sb.toString());
  JOptionPane.showMessageDialog(null, scrollPane);