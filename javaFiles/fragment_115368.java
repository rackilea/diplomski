import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class NodeTest {

  public static void main(String[] args) throws ParseException {
    try {          
      File first = new File("data.txt");
      File second = new File("data1.txt");    

      Node[] nodes1 =  getNodes(first);
      Node[] nodes2 =  getNodes(second);

      print(nodes1);
      print(nodes2);
    } 
    catch(Exception e) {
      System.out.println("Error reading file " + e.getMessage());
    }   
  }

  public static final void print(Node[] nodes) {
    System.out.println("======================");
    for(Node node : nodes) {
      System.out.println(node);
    }
    System.out.println("======================");
  }

  public static final Node[] getNodes(File file) throws IOException {
    FileReader inputHeuristic = new FileReader(file);
    BufferedReader bufferReader = new BufferedReader(inputHeuristic);
    String line;
    List<Node> list = new ArrayList<Node>();
    while ((line = bufferReader.readLine()) != null) {
      String[] tokens = line.split(" ");
      list.add(new Node(tokens[0], tokens[1]));               
    }
    bufferReader.close(); 
    return list.toArray(new Node[list.size()]);
  } 
}

class Node {
  String start;
  String end;

  public Node(String start, String end){
    this.start = start;
    this.end = end;
  }

  public String toString() {
    return "[" + start + "][" + end + "]";
  }
}