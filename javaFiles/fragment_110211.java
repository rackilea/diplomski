BookCategory categoryA = new BookCategory("Category A");
categoryA.setBooks(new HashSet<Book>(){{
                  add(new Book("Book A1", categoryA));
                  add(new Book("Book A2", categoryA));
                  add(new Book("Book A3", categoryA));
                }});