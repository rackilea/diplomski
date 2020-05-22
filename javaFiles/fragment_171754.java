import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Test { 
  public static void main (String args[]) throws IOException{
    Scanner sc2 = null;
    HashSet withoutDuplicatesHashSet = new HashSet();
    try {
        sc2 = new Scanner(new File("sample.txt"));

    } catch (FileNotFoundException e) {
        e.printStackTrace();  
    }
    while (sc2.hasNextLine()) {
        Scanner s2 = new Scanner(sc2.nextLine());
        boolean b;
        while (b = s2.hasNext()) {
            String s = s2.next();
            withoutDuplicatesHashSet.add(s);
            System.out.println(s);
        }
    }
    System.out.println(withoutDuplicatesHashSet);

    PrintStream out = new PrintStream(new FileOutputStream("WithoutDuplicates.txt"));
    Iterator hashSetIterator = withoutDuplicatesHashSet.iterator();
    while(hashSetIterator.hasNext()){
        out.println(hashSetIterator.next());
    }

  }
}