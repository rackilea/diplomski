private ArrayList<Contact> list = new ArrayList<Contact>();

    public Contact(String first, String last, String number) {
    this.first=first;
    this.last = last;
    this.number=number;
}
 public void add(String first, String last, String number){
     c=new Contact(first,last,number);
     list.add(c);
}