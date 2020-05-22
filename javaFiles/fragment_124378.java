import java.io.File;
import java.util.*;

class Test {

    private static Random r = new Random();

    public static File getRandomFileIn(File f) {

        File[] subs = f.listFiles();

        if (f.isFile() || f.list().length == 0)
            return f;

        List<File> subDirs = new ArrayList<File>(Arrays.asList(subs));

        Iterator<File> files = subDirs.iterator();
        while (files.hasNext())
            if (!files.next().isDirectory())
                files.remove();

        while (!subDirs.isEmpty()) {
            File rndSubDir = subDirs.get(r.nextInt(subDirs.size()));
            File rndSubFile = getRandomFileIn(rndSubDir);
            if (rndSubFile != null)
                return rndSubFile;
            subDirs.remove(rndSubDir);
        }

        return null;
    }

    public static void main(String[] args) {

        File[] roots = File.listRoots();
        File rndFile = getRandomFileIn(roots[r.nextInt(roots.length)]);

        System.out.println(rndFile);
    }
}