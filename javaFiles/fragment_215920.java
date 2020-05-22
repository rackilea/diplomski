int cmpResult = newValue.compareTo(tree.getValue();
if (cmpResult == 0){
    System.out.println("equals, incrementing count...");
    tree.count.incrementAndGet();
}else if(cmpResult > 0){
    addRight(tree, newValue);
}else{
    addLeft(tree, newValue);
}