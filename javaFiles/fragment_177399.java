import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

/**
 * Finds the largest file using DFS.
 */
public class Finder {

    /**
     * If no start location is given, the we start the search in the current dir
     *
     * @param args {@link String}[] start location for the largest file search.
     */
    public static void main(final String[] args) {
        Path path = Paths.get(args.length < 1 ? "." : args[0]);
        final File ex = findExtremeFile(path);
        System.out.printf("Starting at : %s, the largest file was found here:\n%s\n its size is: %d\n",
                path.toAbsolutePath().toString(),
                ex.getAbsolutePath(),
                ex.length());
    }

    /**
     * Identifies the more extreme of two given files.
     * Modifying this method allows to search for other extremes, like smallest, oldest, etc.
     *
     * @param f1 {@link File} 1st file
     * @param f2 {@link File} 2nd file
     * @return {@link File} the more extreme of the two given files.
     */
    static File extreme(final File f1, final File f2) {

        //if one file is not a valid file, return the other
        if (f1 == null || !f1.exists() ||  !f1.isFile() ){
            if (f2 != null && f2.exists() && f2.isFile()) return f2;
            else throw new IllegalArgumentException();
        }

        if (f2 == null || !f2.exists() ||  !f2.isFile() ){
            if (f1 != null && f1.exists() && f1.isFile()) return f1;
            else throw new IllegalArgumentException();
        }

        //return the largest file
        return f1.length() > f2.length() ? f1 : f2 ;
    }

    /**
     * DFS for the most extreme file, starting the search at a given directory path.
     *
     * @param p {@link Path} path to a directory
     * @return {@link File} most extreme file in the given path
     */
    static File findExtremeFile(final Path p) {

        File x = null; //extreme file
        final LinkedList<File> stack = new LinkedList<>(); //stack for directories
        stack.push(p.toFile());
        //implement dfs
        while (! stack.isEmpty()){
            File dir = stack.pop();
            final File[] fa = dir.listFiles();
            if (fa == null) {
                continue;  // if null then directory is probably not accessible
            }

            for(File f : fa){
                if(f.isDirectory()) { //if directory push to stack
                    stack.push(f);
                    continue;
                }
                //if not directory check if extreme
                if(x != null) {
                    x = extreme(x, f);
                }
                else {
                    x =  f; //for first time
                }
            }
        }
        return x;
    }
}