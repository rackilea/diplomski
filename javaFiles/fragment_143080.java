public class Book {

    ArrayList<Author> authors = new ArrayList<>();

    public Book() {

    }

    public Book(String title, int copyright, int edition, String isbn, ArrayList<Author> authors) { 
        /* 
          I left these fields out of this example on purpose.
        this.title = title; 
        this.copyright = copyright; 
        this.edition = edition; 
        this.isbn = isbn; */
        this.authors = authors; 
    }

    public void promptForAuthors()
    {
        Scanner scan = new Scanner(System.in);
        String response = "Y";

        do {
            System.out.println("Please enter the author. ");
            String input = scan.nextLine();
            String [] splitAuthors = input.split(" ");

            Author author = new Author(splitAuthors[0], splitAuthors[1]);

            if (!this.authors.contains(author)) {
                this.authors.add(author);
            }

            System.out.println("Would you like you add an additional author? (Y or N) ");
            response = scan.nextLine();

        } while(response.equalsIgnoreCase("Y"));
    }

    public void printAuthors() {
        for (Author a : this.authors) {
            System.out.println(a.getFirstName() + " " + a.getLastName());
        }
    }

    public static void main(String[] args) {
        Book b = new Book(); //This will normally be the constructor that includes the ISBN, copyright, etc.
        b.promptForAuthors();
        b.printAuthors();
    }
}