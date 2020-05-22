import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class DirStuctureReader {

  private static final int INDENTATION = 4;

  public static void main(String[] args) throws Exception {
    Directory result = new DirStuctureReader().read(new File("testfile.txt"));
    System.out.println(result);
  }

  public Directory read(File file) throws IOException {
    Scanner scanner = new Scanner(file);
    Stack<Directory> directoryStack = new Stack<>();
    Directory root = new Directory("/"); // a root directory for everything
    directoryStack.add(root);
    while (scanner.hasNextLine()) {
      processLine(scanner.nextLine(), directoryStack);
    }

    return root;
  }

  private void processLine(String line, Stack<Directory> directoryStack) {
    int nLeadingSpaces = getNumberOfLeadingSpaces(line);
    if (nLeadingSpaces == -1) return;
    int depth = nLeadingSpaces / INDENTATION;
    while (directoryStack.size() > depth + 1) {
      directoryStack.pop(); // discard elements from the stack when we are deep and jump up one or more levels
    }
    String dirName = line.substring(nLeadingSpaces + 1);
    Directory directory = new Directory(dirName);
    directoryStack.peek().getChildren().add(directory); // add the directory to the children of the proper parent dir
    directoryStack.push(directory);
  }

  private int getNumberOfLeadingSpaces(String line) {
    for (int i = 0; i < line.length(); i++) {
      if (line.charAt(i) != ' ') return i;
    }

    return -1;
  }

  public static class Directory {
    private List<Directory> children = new ArrayList<>();

    private final String name;

    public Directory(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

    public List<Directory> getChildren() {
      return children;
    }
  }
}