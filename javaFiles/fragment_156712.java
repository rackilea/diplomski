public class Client {

    public static void main(String[] args) {

        String secretKey = "<MY_SECRET_KEY>";
        String awsKey = "<MY AWS KEY>";

        System.out.println("API Test started");


        AWSECommerceService service = new AWSECommerceService();
        service.setHandlerResolver(new AwsHandlerResolver(secretKey)); // important
        AWSECommerceServicePortType port = service.getAWSECommerceServicePort();

        // Get the operation object:
        com.ECS.client.jax.ItemSearchRequest itemRequest = new com.ECS.client.jax.ItemSearchRequest();

        // Fill in the request object:
        itemRequest.setSearchIndex("Books");
        itemRequest.setKeywords("Star Wars");
        itemRequest.getResponseGroup().add("Large");
//      itemRequest.getResponseGroup().add("Images");
        // itemRequest.setVersion("2011-08-01");
        com.ECS.client.jax.ItemSearch ItemElement = new com.ECS.client.jax.ItemSearch();
        ItemElement.setAWSAccessKeyId(awsKey);
        ItemElement.setAssociateTag("th0426-20");
        ItemElement.getRequest().add(itemRequest);

        // Call the Web service operation and store the response
        // in the response object:
        com.ECS.client.jax.ItemSearchResponse response = port
                .itemSearch(ItemElement);

        String r = response.toString();
        System.out.println("response: " + r);

        for (Items itemList : response.getItems()) {
            System.out.println(itemList);

            for (Item itemObj : itemList.getItem()) {

                System.out.println(itemObj.getItemAttributes().getTitle()); // Title
                System.out.println(itemObj.getDetailPageURL()); // Amazon URL
            }
        }

        System.out.println("API Test stopped");

    }
}