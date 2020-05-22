import java.io.File;
import java.util.Calendar;

public class DeleteOlderThan
{

    private static long daysAgo;

    private static void delete(File f) {
        if (f.isDirectory()) {
            for (File l : f.listFiles())
                delete(l);
        }
        if (f.lastModified() <= daysAgo) {
            f.delete();
        }
    }

    public static void main(String[] args)
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1 * new Integer(args[1]));
        daysAgo = cal.getTimeInMillis();

        delete(new File(args[0]));
    }
}