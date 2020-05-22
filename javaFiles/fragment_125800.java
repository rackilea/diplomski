class thelibrary {
    public static ArrayList<Book> list = new ArrayList<Book>();

    public static void allBooks() {

            Book obj1 = new Book("Harry Potter and the Philosopher's Stone","JK Rowling","Bloomsbury","Genre",1997,223);
            Book obj2 = new Book("Alexander Hamilton","Ron Chernow","Head of Zeus","Biograophy",2016,818);
            Book obj3 = new Book("To Kill a Mockingbird","Harper Lee","Arrow","Southern Gothic",1960,309);

            list.add(obj1);
            list.add(obj2);
            list.add(obj3);

            for(Book ob : list) {

                System.out.println("Title: " + ob.title);
                System.out.println("Author: " + ob.author);
                System.out.println("Publisher: " + ob.publisher);
                System.out.println("Genre: " + ob.genre);
                System.out.println("Year: " + ob.year);
                System.out.println("Pages: " + ob.pages);

                System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - ");
            }

            Menu.bookmenu();
        }

        public static void addBooks() {
            Scanner newBooks = new Scanner(System.in);

            for (int i = 0; i < 1; i++) {
            System.out.println("\n\nAdd a new book to the library:");

            System.out.println("\n>Please enter book title: ");
            String title = newBooks.nextLine();

            System.out.println(">Please enter book author: ");
            String author = newBooks.nextLine();

            System.out.println(">Please enter book publisher: ");
            String publisher = newBooks.nextLine();

            System.out.println(">Please enter book genre: ");
            String genre = newBooks.nextLine();

            System.out.println(">Please enter book release year: ");
            int year = newBooks.nextInt();

            System.out.println(">Please enter number of book pages: ");
            int pages = newBooks.nextInt();

            list.add(new Book(title, author, publisher, genre, year, pages));

            System.out.println("You have successfully added a new book to the library!");
            Menu.bookmenu();   
        }
    }