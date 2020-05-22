import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class ProductDetails {

private String productName;
private String productVersion;
private List<ProductDetails> productData = null;

public ProductDetails(String productName,String productVersion){
    this.productName = productName;
    this.productVersion = productVersion;
    if(productData == null) {
        productData = new ArrayList<ProductDetails>();
        adNewProduct(this);
    }
}

private void  adNewProduct(ProductDetails p){
    String[] s1 = p.productVersion.split(Pattern.quote("."));
    for (ProductDetails dpp: productData) {
        if (dpp.productName.equals(p.productName)) {
            int index = productData.indexOf(dpp);
            String[] s2 = dpp.productVersion.split(Pattern.quote("."));
            for(int i = 0; i < s1.length; i++) {
                int v1 = Integer.valueOf(s1[i]);
                int v2 = Integer.valueOf(s2[i]);

                if (v1 > v2) {
                    productData.set(index,p);
                    return;
                }
            }
        }
    }
    productData.add(p);
}


@Override  // you can modify it to how you want
public String toString(){

    String s = "";

    for (ProductDetails p: productData){
        s += "ProductName: " + p.productName + " ProductVersion: " + p.productVersion + "\n";
    }
    return s;
}


//the main method
public static void main(String[] args) {
    ProductDetails k = new ProductDetails("ios", "9.1.1");
    k.adNewProduct(new ProductDetails("android", "5.1.1"));
    k.adNewProduct(new ProductDetails("android", "6.0.1"));
    k.adNewProduct(new ProductDetails("ios", "10.0.0"));

    System.out.println(k);

    }

}