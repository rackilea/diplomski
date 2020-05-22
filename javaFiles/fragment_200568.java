import java.util.*;
class Node {
    String data;
    Node left, right;

    Node(String item) {
        data = item;
        left = right = null;
    }
}
public class Algo{   
    public Node createBT(String[] arr){
       Node root = null;
       if(arr == null || arr.length == 0) return root;// to handle edge case of empty lists.
       Stack<Node> st = new Stack<>();

       for(int i=0;i<arr.length;++i){
            Node new_node = new Node(arr[i]);
            attachChildToParent(st,new_node);// attach child to it's parent(which will be most recent/top in the stack)
            if(root == null) root = new_node;
            if(isOperator(arr[i])){                                                  
                st.push(new_node); // only push operators to stack as operands will always be leaf nodes
            }
       }

       return root;
    }    

    private boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private void attachChildToParent(Stack<Node> st,Node child_node){
        if(st.isEmpty()) return;
        Node parent_node = st.peek();
        if(parent_node.left == null){
            parent_node.left = child_node;
        }else{
            parent_node.right = child_node;
            st.pop(); // no need to keep parent in the stack anymore since we assigned nodes on both ends(left and right) 
        }
    }

    private void preorder(Node root,List<String> nodes){
        if(root == null) return;
        nodes.add(root.data);
        preorder(root.left,nodes);
        preorder(root.right,nodes);        
    }

    public static void main(String[] args) {
        String[][] test_cases = new String[][]{
            {"-", "-", "x", "y", "*", "+", "s", "t", "/", "x", "s"},
            {"/","-", "-", "x", "y", "*", "+", "s", "t", "/", "x", "s","t"},
            {"y"}
        };        
        Algo obj = new Algo();
        for(int i=0;i<test_cases.length;++i){
            Node root = obj.createBT(test_cases[i]);
            List<String> preorder_result = new ArrayList<>();
            obj.preorder(root,preorder_result);
            boolean expected_success = true;
            for(int j=0;j<test_cases[i].length;++j){
                if(!test_cases[i][j].equals(preorder_result.get(j))){
                    expected_success = false;
                    break;
                }                
            }
            System.out.println("Test Case: " + Arrays.toString(test_cases[i]));
            if(expected_success){
                System.out.println("Result: ok");
            }else{
                System.out.println("Result: not ok");
            }
        }

    }
}