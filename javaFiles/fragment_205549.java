private static boolean compareNodes(Node currentNode, Queue<Node> fifo, ArrayList<Node> explored){
    boolean exists = false;
    while(!fifo.isEmpty()){
        exists = fifo.contains(currentNode);
        if(exists){
            //System.out.println("Exists in fifo");
            break;
        }
    }
    if(exists){

    }else{
        for(Node n: explored){
            if(n.equals(currentNode)){
                //System.out.println("Exists in explored");
                exists = true;
                break;
            }else{
                //keep on going
            }
        }
    }

    return exists;
}