public static void main(String[] args) {
    User odaSensei = new User();
    odaSensei.name = "Oda-Sensei";

    User michaelBay = new User();
    michaelBay.name = "Michael Bay";


    Book firstBook = new Book("One Piece", odaSensei, 100, 123456);
    Book secondBook = new Book("Life of Megan Fox", michaelBay, 200, 928765);
}