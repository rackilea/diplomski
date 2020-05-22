import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OpCodeLookupService {

Pair[] opCodes;

public static final class Pair {
    String first;
    String second;

    public Pair(String first, String second) {
        this.first = first;
        this.second = second;
    }
}

public OpCodeLookupService(Pair[] opCodes) {
    this.opCodes = opCodes;
}

public Pair pairLookup(String toLookup) {
    for(Pair p : this.opCodes) {
        if (p.first.equals(toLookup)) {
            return p;
        }
    }
    return null;
}

public String lookup(String filePath) {
    try {
        // In the comments, you mentioned you cannot use BufferedReader to ingest the file. In this example, I'm showing another way via Scanner which is a very easy to use class for ingesting input streams.
        Scanner s = new Scanner(new FileInputStream(filePath));
        StringBuilder stringToExamine = new StringBuilder();
        while (s.hasNext()) {
            String nextString = s.next();
            for (char c : nextString.toCharArray()) {
                stringToExamine.append(c);
                Pair pair = pairLookup(stringToExamine.toString());
                if (pair != null) {
                    return pair.second;
                }
            }
        }
        return null; //Indicates string is not found.
    } catch (FileNotFoundException e) {
        e.printStackTrace();
        throw new RuntimeException("Cannot load file");
    }
}


public static void main(String...args) {
    final Pair p = new Pair("thisisopcode", "12345");
    Pair[] pairs = new Pair[1];
    pairs[0] = p;
    OpCodeLookupService opService = new OpCodeLookupService(pairs);
    System.out.println(opService.lookup("/Users/liuben10/foo.txt"));
  }
}