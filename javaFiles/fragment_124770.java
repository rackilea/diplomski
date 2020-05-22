package stackoverflow.questions.q18930222;

import com.google.gson.Gson;

public class Q18930222 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String jsonString = "{\"d\":{\"__type\":\"DealMeDataContract\",\"DealMe\":[{\"__type\":\"DealMe\",\"Address\":\"2075 n power line rd  suit 1\",\"CategoryId\":\"1\",\"CategoryName\":\"Personal\",\"City\":\"pompano    beach\",\"CreatedDate\":\"\\/Date(1377621018533+0000)\\/\",\"DealMeId\":\"5b9b00d9-e8bf-4197-bd2a-36bc5872359f\",\"Description\":\" Get 2 Kick-it Kits now for the price of one. Only $19.99\\u000d\\u000aYou welse!\",\"ExpiryDate\":\"\\/Date(1383263940000+0000)\\/\",\"HasAgreedTermsAndConditions\":true,\"ImageUrl\":\"null\",\"IsNewAddress\":false,\"LastUpdatedDate\":\"\\/Date(1377621018533+0000)\\/\",\"Latitude\":26.24161,\"Longitude\":-80.1f909,\"PhoneNumber\":\"(954)-454-88\",\"PreviousDealAddress\":\"2075 ne rd suit 1\",\"PreviousDealCity\":\"pompano beach\",\"PreviousDealState\":\"FL\",\"PreviousDealZipCode\":\"33069\",\"StartDate\":\"\\/Date(11017920+0000)\\/\",\"State\":\"FL\",\"StateList\":[{\"__type\":\"SelectListItem:#SyMvc\",\"Selected\":false,\"Text\":\"---Please select a State---\",\"Value\":null},{\"__type\":\"SelectListItem:#Syseb.Mvc\",\"Selected\":false,\"Text\":\"Alabama\",\"Value\":\"AL\"},{\"__type\":\"SelectListItem:#Sys.Mvc\",\"Selected\":false,\"Text\":\"Alaska\",\"Value\":\"AK\"}],\"SubCategoryId\":\"124\",\"SubCategoryName\":\"Electronics\",\"Title\":\"Kice stand \",\"UserId\":\"b3bd\",\"ZipCode\":\"45469\"}],\"Status\":\"Success\"}}";
        Gson mGson = new Gson();
        Container cateResponse = mGson.fromJson(jsonString, Container.class);
        System.out.println(cateResponse);

    }
}