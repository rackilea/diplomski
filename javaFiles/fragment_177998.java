import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Graph {
  final Set<Integer> nodes = new HashSet<>();
  final Map<Integer, Set<Integer>> edges = new HashMap<>();

  static class Reader {
    String fileName;
    Graph graph;

    Reader(String fileName) {
      this.fileName = fileName;
    }

    Graph read() {
      try {
        return scanGraph();
      } catch (FileNotFoundException ignore) {
        return new Graph();
      }
    }

    Graph scanGraph() throws FileNotFoundException {
      graph = new Graph();
      Scanner scanner = new Scanner(new File(fileName));
      while (scanner.hasNextInt()) {
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        graph.nodes.add(n1);
        graph.nodes.add(n2);
        addDirectedEdge(n1, n2);
      }
      return graph;
    }

    void addDirectedEdge(Integer n1, Integer n2) {
      if (graph.edges.containsKey(n1)) {
        graph.edges.get(n1).add(n2);
      } else {
        Set<Integer> to = new HashSet<>();
        to.add(n2);
        graph.edges.put(n1, to);
      }
    }    
  }

  interface Visitor {
    void visit(int node);
  }    

  void visitDepthFirst(int start, Visitor visitor) {
    visitDepthFirst(start, visitor, new HashSet<>());
  }

  void visitDepthFirst(int node, Visitor visitor, Set<Integer> visited) {
    visitor.visit(node);
    visited.add(node);
    Set<Integer> successors = edges.get(node);
    if (successors == null) {
      return;
    }
    for (int successor : successors) {
      if (!visited.contains(successor)) {
        visitDepthFirst(successor, visitor, visited);
      }
    }
  }

  public static void main(String [] args) {
    Graph graph = new Graph.Reader(args[0]).read();
    System.out.println("The graph has " + graph.nodes.size() + " nodes:");
    System.out.println(graph.nodes);
    System.out.println("Adjacency list:");
    System.out.println(graph.edges);
    System.out.println("A preorder depth first visit starting from 0:");
    graph.visitDepthFirst(0, new Visitor() {
      @Override
      public void visit(int node) {
        System.out.println("Visiting " + node);
      }
    });
  }
}