public void deleteProduct(String ID) {
    System.out.println("Enter product id to delete: ");
    ID = input.next();
    Product toRemove = null;
    for(Product r : s.P) {
        if(ID.equals(r.getID())) {
            toRemove = r;
            break;
        }
    }
    if(toRemove == null) {
        System.out.println("ID is not exist");
    }
    else {
        s.P.remove(toRemove);
    }
}