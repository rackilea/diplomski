int maxNodes = Integer.MIN_VALUE;
int index = -1;
for(int i=0; i<LinkedList.size(); i++){
    int nodes = 0;
    for(int j=0; j<nestedLinkedList.size(); j++){
        System.out.print(NodeInformation);
        nodes++;
    }
    if(nodes>maxNodes){
        index = i;
        maxNodes = nodes;
    }
    System.out.println();
}