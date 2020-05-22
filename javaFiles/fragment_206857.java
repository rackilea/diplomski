import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class BFSRecursive {

public static void main(String[] args) {

    File file = new File("D:/Tomcat");

    Queue<File> files = new LinkedList<>();
    files.add(file);
    bfs(files);

}

private static void bfs(Queue<File> files) {

    if (files.isEmpty())
        return;

    File file = files.poll();
    System.out.println(file.getName());

    String[] directories = file.list();

    for(String child: directories) {
        File childFile = new File(file.getAbsolutePath() +"/"+ child);

        if (childFile.isDirectory())
            files.add(childFile);
    }

    bfs(files);
  }
}