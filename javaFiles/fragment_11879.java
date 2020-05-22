import java.awt.event.*;
import java.util.List;
import javax.swing.JButton;

public class Foo {
   public List<Product> productList;

   public static void main(String[] args) {
      Foo f = new Foo();
      A a = new A(f);

   }

   public void addNewProduct(String name) {
      Product product = new Product();
      product.setName(name);
      productList.add(product);
   }
}

class A {
   private JButton saveButton = new JButton();
   private Foo foo;

   public A(final Foo foo) {
      this.foo = foo;
      saveButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent event) {
            foo.addNewProduct("Hello World");
         }
      });
   }
}

class Product {

   public void setName(String name) {
      // TODO Auto-generated method stub

   }

}