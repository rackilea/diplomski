switch (position) {
                    case 1:
                        intent = new Intent(BookList.this, BookListView.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(BookList.this, BookListAuthorView.class);
                        startActivity(intent);
                        break;
                }