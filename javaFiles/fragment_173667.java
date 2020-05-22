public class Test {

  public void static main(String[] args) {

     Product product = new Product() {

            @Override
            public void display() {
                //add your code to display

            }
        };

    //now using reference, you can call display()
    product.display();
}