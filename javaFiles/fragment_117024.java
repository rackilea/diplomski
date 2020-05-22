public class PriceSorter implements Comparator<Product>{

    public int compare(Product one, Product another){
        int returnVal = 0;

    if(one.getPrice() < another.getPrice()){
        returnVal =  -1;
    }else if(one.getPrice() > another.getPrice()){
        returnVal =  1;
    }else if(one.getPrice() == another.getPrice()){
        returnVal =  0;
    }
    return returnVal;
    }
}