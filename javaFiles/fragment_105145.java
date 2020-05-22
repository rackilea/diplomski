public class Bst<Key extends Comparable<Key>, Value>  {
    private Node root;   

    private class Node {
        private Key phone_number;            
        private Value contact_name;        
        private Node left, right;   
        public Node(Key phone_number, Value contact_name) {
            this.phone_number   = phone_number;
            this.contact_name = contact_name;
        }
    }
    public boolean contains(Key phone_number) {
        return (get(phone_number) != null);
    }

    // return contact_name associated with the given phone_number

    public Value get(Key phone_number) {
        root = splay(root, phone_number);
        int cmp = phone_number.compareTo(root.phone_number);
        if (cmp == 0)
            return root.contact_name;
        else
            return null;
    } 


    public String printTree( )
    {
        if( isEmpty( ) )
            return "Empty tree";
        else
        {
            StringBuilder sb = new StringBuilder();
            printTree( root, sb );
            return sb.toString();
        }
    }

    private void printTree( Node t, StringBuilder sb )
    {
        if ( t.left != null ) 
        {
            sb.append( "Phone Number:" + t.phone_number.toString( ) + "  Contact Name : " + t.contact_name.toString( ) );
            printTree( t.left, sb );
        } 

        if (t.right != null)
        {
                printTree( t.right, sb );
                sb.append( "name:" + t.phone_number.toString( ) + "  Number : " + t.contact_name.toString( )  );
        }
    }
 }