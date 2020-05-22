public class MyApp{

  private List<Sale> list = new ArrayList<>();
  public static void main(String[] args){
     new MyApp();
  }


  public MyApp(){
      // init an instance of the class
  }

  // ....
  private void btn_saveClientActionPerformed(java.awt.event.ActionEvent evt) {                                               
        Sale sale;
        String clientName = txtFied_Name.getText().toString();
        String product = txtField_product.getText().toString();

        sale = new Sale(clientName, product);
        // list is now accessible as it is an instance field and a 
        //  instance method of the same class can refer to it
        list.add(sale); 
  } 

}