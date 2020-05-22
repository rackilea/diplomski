PhoneBook(int pages, String city) {
        super(pages);  // u can even remove this its not needed
        area = city;
        if (pages > 300) {
            size = "big";
        } else {
            size = "small";
        }

public void display(int pages,String area) {
    System.out.println( area + pages + size);
}
}