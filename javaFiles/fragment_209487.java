import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StudentIDsRetriever {

    public static void main(String[] args) throws IOException {
        File dir = new File("htmldir");
        String[] htmlFiles = dir.list();
        List<String> studentIds = new ArrayList<>();
        List<String> emailDs = new ArrayList<>();
        for (String htmlFile : htmlFiles) {
            Path path = FileSystems.getDefault().getPath("htmldir", htmlFile);
            List<String> lines = Files.readAllLines(path);
            for (String str : lines) {
                if (str.contains("<p>Student ID:")) {
                    String idTag = str.substring(str.indexOf("<p>Student ID:"));
                    String id = idTag.substring("<p>Student ID:".length(), idTag.indexOf("</p>"));
                    System.out.println("Id is "+id);
                    studentIds.add(id);
                }

                if (str.contains("@") && (str.contains(".com") || str.contains(".co.in"))) {
                    String[] words = str.split(" ");
                    for (String word : words) 
                        if (word.contains("@") && (word.contains(".com") || word.contains(".co.in"))) 
                            emailDs.add(word);
                }

            }
        }
        System.out.println("Student list is "+studentIds);
        System.out.println("Student email list is "+emailDs);
    }
}