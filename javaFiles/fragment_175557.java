public class CartCredentialsCollector {
//it should return something like this: 
//store_url=https://test.myshopify.com&apiKey=myapikey&apiPassword=myapipassword

public String credentailsCollector() throws IOException {
    String test = null;
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Do you want to connect a new shopping cart ('yes'/'no')");
    String newConnection = bufferedReader.readLine();
    if (newConnection.equals("no")) {
        bufferedReader.close();
    } else {
        System.out.println("Specify your shopping cart. It works with Shopify and Bigcommerce only");
        String newShoppingCart = bufferedReader.readLine();
        if (newShoppingCart.equals("Shopify")) {
            ShopifyCredentialsHandler sch = new ShopifyCredentialsHandler();
            test = sch.shopifyCredentialsHandler();
        }
        else if (newShoppingCart.equals("Bigcommerce")) {
        BigcommerceCredentialsHandler bch = new BigcommerceCredentialsHandler();
        test = bch.bigcommerceCredentialsHandler()
        }

        else {
            System.out.println("This method works with Shopify. Try to connect a Shopify store.");
            bufferedReader.close();
        }
    }
    return test;
    // Here I need to return test (in case I choose "Shopify") or test2 (in case I choose "Bigcommerce"). How can I do that?
    }
}