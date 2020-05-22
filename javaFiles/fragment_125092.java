import java.util.*;
// This is your existing code:
class Node { 
    private String label;
    private List<Node> children = new ArrayList<Node>();

    // Here's how you would build one with that strucure
    public static void main( String ... args ) { 

        Node one = new Node();
        one.label = "1";

        Node two = new Node();
        two.label = "2";

        Node root = new Node();
        root.label = "plus";
        root.children.add( one );
        root.children.add( two );

        print( root );
    }

    // Here's how you'll print the values
    static void print( Node node ) { 

         System.out.println( node.label );

         for( Node child : node.children ) { 
            // if child is a branch 
            if( child.children.size() > 0 ) { 
                // print the branch ( recursively ) 
                print( child );
             } else { 
                // is a leaf, just print the label.
                System.out.println( "-- ["+child.label+"]" );
             }
          }
     }
}