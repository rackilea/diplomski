public class PurchaseOrderList {

    private ArrayList<PurchaseOrder> purchaseCollection;

    public PurchaseOrderList() {
        purchaseCollection = new ArrayList<PurchaseOrder>();
    }

    //THIS IS THE IMPORTANT PART
    public void clearPurchaseCollection() {
        purchaseCollection.clear();
        //You could also accomplish the same thing by reinitializing the list:
        //purchaseCollection = new ArrayList<PurchaseOrder>();
    }

}