public void reverse() {
  System.out.println(toFormattedString());

  int x = this.size();
  this.add(front.data);
  System.out.println(toFormattedString());

  for (int i = 0; i < x; i++) {
    this.remove(0);
    System.out.println(toFormattedString());
    this.add(this.size() - 1, front.data);
    System.out.println(toFormattedString());
  }
}