public class Manual {
    private String serial;
    private String title;
    private String author;
    //... more String fields
    public Manual( String line ){
        String[] fields = line.split( "\t" );
        serial = fields[0];
        title = fields[1];
        //... and so on for other fields
    } 
    public String asLine(){
        return String.join( "\t", serial, title, author, // more fields
                           );
    }
}