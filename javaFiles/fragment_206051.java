public class BookKeeper{
private static BookKeeper instance;

private BookKeeper{
}

public synchronized static BookKeeper getInstance(){
if(instance == null){
 instance = new BookKeeper();
}
return instance;
}