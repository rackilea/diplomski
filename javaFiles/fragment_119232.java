//returns the Product which matches the name given by the parameter
//only works for unique names
public Product nameLookup(String name){
    for(Product p: products_table){
        if(name.equals(p.getProductName()))
            return p;
    }
}

//If names are not unique
public ArrayList<Product> nameLookup(String name){
    List<Product> templist = new ArrayList<Product>();
    for(Product p: products_table){
        if(name.equals(p.getProductName()))
            templist.add(p);
    }
    return templist;
}