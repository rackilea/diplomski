public static void main(String []arg){
    String name;
    String author;
    String pages;
    Book[] novel = new Book[2];
    novel[0] = new Book();
    novel[1] = new Book();
    novel[2] = new Book();
    novel[3] = new Book();
    novel[4] = new Book();
    Scanner kb = new Scanner(System.in);
    for (int i = 0; i< novel.length;)
    {   
        System.out.println("Please Enter the books title");
        name = kb.nextLine();
        novel[i].setTitle(name);
        System.out.println("Please enter the books author");
        author = kb.nextLine();
        novel[i].setAuthor(author);
        System.out.println("Please enter the number of pages in this book");
        pages = kb.nextLine();
        novel[i].setPages(Integer.parseInt(pages));
        System.out.println(""+novel[i].title);
        System.out.println(""+novel[i].author);
        System.out.println(""+novel[i].getPages());
        ++i;
    }
    for (int x = 0; x<novel.length; x++)
    {
    System.out.print(""+ novel[x].title + "\n" + novel[x].author + "\n" + novel[x].pages);
    }