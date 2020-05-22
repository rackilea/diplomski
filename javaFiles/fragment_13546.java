public void onClick(View view) {
        ArrayList<book> lstBook = new ArrayList<>();
        Book b1 = new Book();
        b1.id = 1L;
        b1.name = "test 1";
        lstBook.add(b1);
        Book b2 = new Book();
        b2.id = 2L;
        b2.name = "test 2";       
        lstBook.add(b2);

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putParcelableArrayListExtra("TEST", lstBook);
        startActivity(intent);
    }