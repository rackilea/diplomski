List<Hardware> list = new ArrayList<Hardware>();
list.add(new Hardware("Ram", 2));
list.add(new Hardware("Keyboard", 3));
list.add(new Hardware("Mouse", 5));
list.add(new Hardware("Keyboard", 5));
list.add(new Hardware("Mouse", 1));

for (int i = 0; i < list.size(); i++) {
  Hardware current = list.get(i);
  for (int j = i + 1; j < list.size(); j++) {
    Hardware compare = list.get(j);
    if (current.getName().equals(compare.getName())) {
      current.setQuantity(current.getQuantity() + compare.getQuantity());
      list.remove(compare);
      j--;
    }
  }
}