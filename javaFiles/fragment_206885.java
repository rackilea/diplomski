thisStrand = myHead;
int size = 0;
while(thisStrand != null){
    thisStrand = thisStrand.myNext;
    size++;
}
Node[] nodeArray = new Node[size];
thisStrand = myHead;
for(int i = size-1, i < 0; i--) {
    nodeArray[i] = thisStrand;
}