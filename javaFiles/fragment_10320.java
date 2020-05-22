if (tds.size() > 6) {
  // now the string a contains the text of all of the table cells joined together
  String a = tds.get(0).text() + tds.get(1).text() + tds.get(2).text() +
      tds.get(3).text() + tds.get(4).text() + tds.get(5).text() + tds.get(6).text();

  // now the list contains the string
  list.add(a);

  // now you're looking in the list (which has all the table cells' items)
  // for just the string "Claude", which doesn't exist
  int claudesPos = list.indexOf(claude);
  System.out.println(claudesPos);

  // but this might give you the position of "Claude" within the string you built
  System.out.println(a.indexOf(claude));
}

for (int i = 0; i < list.size(); i += 1) {
  if (list.get(i).indexOf(claude) != -1) {
    // list.get(i).contains(claude) works too
    // and this will give you the index of the string containing Claude
    // (but not the position within that string)
    System.out.println(i);
  }
}