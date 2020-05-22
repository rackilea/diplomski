int limit = 100;
String query = "select UID from accounts where ... " + limit; // add your query here i.e. email = 'someone@example.com'
String cursorId = ""; 
int objectsCount = limit;

GSRequest searchRequest;
ArrayList<String> uidList = new ArrayList<String>();

// send request
do 
{
    // check if we have an open cursor
    if(cursorId.length() > 0)
    {
        // run next request in cursor

        // set up request
        searchRequest = new GSRequest(apiKey, secretKey, "accounts.search");
        //searchRequest.setAPIDomain("eu1.gigya.com");
        //searchRequest.setUseHTTPS(true);

        // set timeout
        searchRequest.setParam("timeout", 60000);

        // set cursor id
        searchRequest.setParam("cursorId", cursorId);
    } else {
        // run new request and open cursor

        // set up request
        searchRequest = new GSRequest(apiKey, secretKey, "accounts.search");
        //searchRequest.setAPIDomain("eu1.gigya.com");
        //searchRequest.setUseHTTPS(true);

        // set timeout
        searchRequest.setParam("timeout", 60000);

        // set query
        searchRequest.setParam("query", query);

        // open cursor
        searchRequest.setParam("openCursor", true);
    }

    GSResponse searchResponse = searchRequest.send();
    if(searchResponse.getErrorCode()==0)
    {     
        GSArray uids = new GSArray();
        uids = searchResponse.getArray("results", uids);
        for(int i=0; i<uids.length(); i++)
        {
            String uid;
            try {
                // retrieve uid and add to list of uids
                uid = uids.getObject(i).getString("UID");
                uidList.add(uid);

            } catch (GSKeyNotFoundException e) {
            }

        }

        cursorId = searchResponse.getString("nextCursorId", "");
        objectsCount = searchResponse.getInt("objectsCount", 0);
    } 
    else 
    {  
        System.out.println("searchRequest failure: " + searchResponse.getLog());
    } 
} 
while (objectsCount >= limit);

for(int i=0; i<uidList.size(); i++)
{
    String uid;
    try {
        uid = uidList.get(i);

        // delete user record
        GSRequest deleteAccountRequest = new GSRequest(apiKey, secretKey, "accounts.deleteAccount");
        //deleteAccountRequest.setAPIDomain("eu1.gigya.com");
        deleteAccountRequest.setUseHTTPS(true);
        deleteAccountRequest.setParam("UID", uid);
        GSResponse deleteAccountResponse = deleteAccountRequest.send();
        if(deleteAccountResponse.getErrorCode()==0)
        {     
        } 
        else 
        {  
            System.out.println("deleteAccountResponse failure: " + deleteAccountResponse.getLog());
        }

    } catch (Exception e) {
    }

}