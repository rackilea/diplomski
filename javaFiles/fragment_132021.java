Book(String name,Author a,double price,int qtyInStock)
{
    //pass variables to parent class
    super(a.getName(), a.getEmail(), a.getGender());
    this.name=name;
    this.authorname=a.getName(); //Error
    this.price=price;
    this.qtyInStock=qtyInStock;
}