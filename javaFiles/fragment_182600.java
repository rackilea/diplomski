int numberOfBooks = Integer.parseInt(textReader.readLine());

for (int i = 0; i < numberOfBooks; i++) {
    String post = textReader.readLine();

    int index1 = post.indexOf(END_SIGN);
    int index2 = post.indexOf(END_SIGN, index1 + 1);

    String lastname = post.substring(0, index1);
    String firstname = post.substring(index1 + 1, index2);
    String title = post.substring(index2 + 1);

    Book book = new Book(lastname, firstname, title);

    addBook(book);
}