...
List list = Arrays.asList(wrkrs);
if(list.contains(a)){
    JOptionPane.showMessageDialog(null, "That guy is at work!");
    JOptionPane.showMessageDialog(null, "calling " + wrkrsPhone[list.indexOf(a)]);
}
...