public static JButton button(String name, int size1, int size2, int loc1, int loc2) {
  JButton l=new JButton(name);
  l.setSize(size1, size2);
  l.setLocation(loc1, loc2);
  return l;
}