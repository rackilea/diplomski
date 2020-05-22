1    public class Node
 2  {
 3      private int myInt;
 4      private Node nextNode;
 5     
 6      public Node(int val)
 7      {
 8          myInt = val;
 9          nextNode = null;
10          return this;
11      }
12  
13      public int getMyInt()
14      {
19          return myInt;
20      }
21  
22      public Node(Node prev, int val)
23      {
24          prev.nextNode = this;
25          myInt = val;
26          nextNode = null;
27      }
28  
29      public void addNode(Node newNode)
30      {
31          nextNode = newNode;
32      }
33  
34      public void printNodes()
35      {
36          System.out.println(myInt);
37          if (nextNode != null)
38          {
39              nextNode.printNodes();
40          }
41      }
42  
43      public void printNode()
44      {
45          System.out.println(myInt);
46      }
47
48      public Node nextNode()
49      {
50          return this.nextNode;
51      }
52  }