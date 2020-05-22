List<Book> booklist = new ArrayList<Book>(Arrays.asList(b));

    Collections.sort(booklist, new Comparator<Book>() {

        @Override
        public int compare(Book o1, Book o2) {

            return o2.getPrice() - o1.getPrice();
        }
    });
    if (booklist.size() > 1) {
        System.out.println(booklist.get(1));
    }