public class Handler {
public enum PriceCategory{
    LOW,MID, HIGH;
}
private static class Element{
    private int min;
    private int max;
    private Element(int min, int max){
        this.min=min;
        this.max=max;
    }
}
private static final Map<Element, PriceCategory> map = new HashMap<Element, PriceCategory>();
static{
    map.put(new Element(100, 200), Handler.PriceCategory.LOW);
    map.put(new Element(201, 300), Handler.PriceCategory.MID);
    map.put(new Element(301, 400), Handler.PriceCategory.HIGH);
}
public static String getClassificationForProduct(ProductData product) {
    //here just check for which range this product price is belonging and return that enum/immutable object
}
}