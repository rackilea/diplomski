StringBuilder s = new StringBuilder();
while(i < 11) {
    s.append(" ").append(i);
    i++;
}
System.out.println(s);
JOptionPane.showMessageDialog(null, s, "1-10", 
             JOptionPane.PLAIN_MESSAGE);