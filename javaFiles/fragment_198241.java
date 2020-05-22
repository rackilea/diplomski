public class DatabaseTipoObject {

private static String remote="remote:localhost/";

public static void main(String[] args) {
    String nomeDb="Object";
    String path=remote+nomeDb;

    try {
        OServerAdmin serverAdmin = new OServerAdmin(path).connect("root", "root");
        if(serverAdmin.existsDatabase()){   
            System.out.println("Database '"+nomeDb +"' exist..");
        }
        else{ 
            serverAdmin.createDatabase(nomeDb, "object", "plocal");
            System.out.println(" Database '"+nomeDb +"' created!..");
        }

        OObjectDatabaseTx db = new OObjectDatabaseTx (path);
        db.open("root","root");

        db.getEntityManager().registerEntityClass(Book.class);
        Book book = db.newInstance(Book.class);
        List<String> myAuthors = new ArrayList();
        myAuthors.add("Archimede");
        myAuthors.add("Pitagora");
        book.setAuthors(myAuthors);

        db.save(book);
        System.out.println("Data inserted!" );

        //get info by query
        for (Book book_retrive : db.browseClass(Book.class)) {
            System.out.println("#: " +book_retrive.getAuthors().get(0) );
            System.out.println("#: " +book_retrive.getAuthors().get(1) );
        }

        db.close();

        serverAdmin.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}