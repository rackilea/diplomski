public class Test1 {
   public static void main(String args[]) {
       NotesThread.sinitThread();
       Session s = NotesFactory.createSession();
       Database db = s.openDatabase("someserver","somedb");
       Yourclass yc = new Yourclass();
       System.out.println(yc.getJSONFromView(db,"viewname");
       db.recycle();
       s.recycle();
       NotesThread.stermThread();
   }
}