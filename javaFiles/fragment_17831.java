product = store.getProduct(pOption);
if (product != null){
    System.out.println("Product description : "+product.getName());
    System.out.println("Price : $ "+product.getPrice());
    System.out.println("Set-up Price : $ "+product.getsUpPrice());
    System.out.println("Unit Cost : $ "+product.getunitCost());
    System.out.println("Inventory Cost : $ "+product.getinvCost());
    System.out.println("Amount of Stock : "+product.getstock());
    System.out.println("Amount of Stock : "+product.getdRate());
}else{
    System.out.println("\nThere is no information on this product.\n");
    System.out.println("\nWould you like to try again? (Y or N) \n");
    str = console.next();
    Inv.prodData();
}