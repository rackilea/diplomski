void setNumberDescendants(Node root) {                                        
    for(Node child:root.children){
       setNumberDescendants(child);
       root.descendants += 1+child.descendants;
    }        
} 

class Node{
    int key;   
    int descendants; 
    List<Node> children;     
}