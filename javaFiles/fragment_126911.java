@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    Book b = bookList.get(position);

    Intent i = new Intent(Romance.this, ViewBook.class)
            .putExtra("bookname", b.getTitle())
            .putExtra("category", b.getCategory())
            .putExtra("Bauthor", b.getAuthor())
            .putExtra("Bedition", b.getEdition);

    startActivity(i);
}