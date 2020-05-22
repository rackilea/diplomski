/**
 * Entry point into the API.
 */
public class HypotheticalApi{   
    public static HypotheticalApi getInstance(){
        //Choose an appropriate creation strategy.
    }

    /**
     * Request a User Profile from the REST server.
     * @param userName The user name for which the profile is to be requested.
     * @param callback Callback to execute when the profile is available.
     */
    public void getUserProfile(String userName, final GetResponseCallback callback){
        String restUrl = Utils.constructRestUrlForProfile(userName);
        new GetTask(restUrl, new RestTaskCallback (){
            @Override
            public void onTaskComplete(String response){
                Profile profile = Utils.parseResponseAsProfile(response);
                callback.onDataReceived(profile);
            }
        }).execute();
    }

    /**
     * Submit a user profile to the server.
     * @param profile The profile to submit
     * @param callback The callback to execute when submission status is available.
     */
    public void postUserProfile(Profile profile, final PostCallback callback){
        String restUrl = Utils.constructRestUrlForProfile(profile);
        String requestBody = Utils.serializeProfileAsString(profile);
        new PostTask(restUrl, requestBody, new RestTaskCallback(){
            public void onTaskComplete(String response){
                callback.onPostSuccess();
            }
        }).execute();
    }
}


/**
 * Class definition for a callback to be invoked when the response data for the
 * GET call is available.
 */
public abstract class GetResponseCallback{

    /**
     * Called when the response data for the REST call is ready. <br/>
     * This method is guaranteed to execute on the UI thread.
     * 
     * @param profile The {@code Profile} that was received from the server.
     */
    abstract void onDataReceived(Profile profile);

    /*
     * Additional methods like onPreGet() or onFailure() can be added with default implementations.
     * This is why this has been made and abstract class rather than Interface.
     */
}

/**
 * 
 * Class definition for a callback to be invoked when the response for the data 
 * submission is available.
 * 
 */
public abstract class PostCallback{
    /**
     * Called when a POST success response is received. <br/>
     * This method is guaranteed to execute on the UI thread.
     */
    public abstract void onPostSuccess();

}