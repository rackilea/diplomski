public class RequestArticleList extends ConnectionUtils<Location, Void, String> {
    @Override
    protected String doInBackground(Location... userLocation) {
        return requestArticleList(userLocation);
    }
}