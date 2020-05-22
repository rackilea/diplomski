class aNode{

    //Node Contents
    int NodeInt;
    char NodeChar;

    //constructor
    aNode(){
    }
    aNode(int x, char y){
        NodeInt = x;
        NodeChar = y;
    }
}

class JavaApplication8{

    static aNode node = new aNode();

    public static void main(String[] args){


        node = null;
        node=function(node);

        if(node == null){
            System.out.println("Node is null");
        }
    }

    static aNode function(aNode x){
        if(x == null)
        {
            System.out.println("Node is null");
        }

        x = new aNode(5,'c');

        System.out.println(x.NodeInt);
        System.out.println(x.NodeChar);
        return x;
    }
}