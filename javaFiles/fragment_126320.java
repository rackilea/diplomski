int maxPos=-1;
for(int i=0;i<orders.size();i++){
    String comp=orders.get(i).getCompany();
    int diff=comp.compareTo(dOrder.getCompany());
    if(diff<0){
        maxPos=i;
    } else break; // no need to continue iterating list after that
}
orders.add(maxPos+1,dOrder);