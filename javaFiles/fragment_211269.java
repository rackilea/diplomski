booklistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override 
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(getApplicationContext(), BookInfoActivity.class);


        editTextBooktitle = (TextView) view.findViewById(R.id.text_book_title);
        String book_title = editTextBooktitle.getText().toString();
        intent.putExtra(EXTRA_MSG1, book_title);

        editTextBookauthor = (TextView) view.findViewById(R.id.text_book_author);
        String bookauthor = editTextBookauthor.getText().toString();
        intent.putExtra(EXTRA_MSG2, bookauthor);

        editTextBookdate = (TextView) view.findViewById(R.id.text_book_date);
        String bookdate = editTextBookdate.getText().toString();
        intent.putExtra(EXTRA_MSG3, bookdate);

        editTextBookrating = (TextView) view.findViewById(R.id.text_book_rating);
        String bookrating = editTextBookrating.getText().toString();
        intent.putExtra(EXTRA_MSG4, bookrating);

        editTextBookshelf = (TextView) view.findViewById(R.id.text_book_shelf);
        String bookshelf = editTextBookshelf.getText().toString();
        intent.putExtra(EXTRA_MSG5, bookshelf);

        startActivity(intent);
    }
}