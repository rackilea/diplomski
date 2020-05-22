public class multiServer 
{

    private List<PrintWriter> writers = new ArrayList<PrintWriter>();

    public synchronized void addWriter(PrintWrite out) {
         writers.add(out);
    }
    public synchronized void serveAllWriters(String data) {
         for (int i=0; i<multiServer.writers.size();i++)
         {
             broad=multiServer.writers.get(i);
             broad.println(data);
         }
    }
}