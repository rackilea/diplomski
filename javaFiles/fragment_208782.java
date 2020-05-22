public int calculateCost(){
    if(parentNode != null){
        return movementCost + parentNode.calculateCost();
    } else{
        return movementCost;
    }
}