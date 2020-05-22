NodeMatrix=new BNode[n][];
for(int i=0;i<n;i++) {
    NodeMatrix[i]=new BNode[(int)Math.pow(2,i)];
    for(int j=0; j < NodeMatrix[i].length; j++) {  
        NodeMatrix[i][j]= new BNode(i);
    }
}