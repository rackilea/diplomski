Collections.sort(orderedProductsList, new Comparator<OrderedProduct>(){
    @Override
    public int compare(OrderedProduct op1, OrderedProduct op2){
        if(op1.getSequence() < op2.getSequence())
            return -1;
        else if(op1.getSequence() > op2.getSequence())
            return 1;
        else 
            return op1.getName().compareToIgnoreCase(op2.getName());            
    }
});