public class Invoice
{
    private int quantity;
    private String partNum;
    private String partDesc;
    private double unitPrice;


    //constructor 
    public Invoice ( int initialQuantity, String partNumber, String partDescript, double unitPrice)
    {
    }//end Invoice constructor

public void setInitialQuantity ( int initialQuantity )
    {
            quantity = initialQuantity;
    }   

}