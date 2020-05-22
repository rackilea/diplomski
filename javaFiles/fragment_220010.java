@Override
public int getViewType(int position) {
ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("NativeAd");
query.whereEqualTo("objectId", "fYBeufqdOt");
final String[] n =  new String[1]; 
query.getFirstInBackground(new GetCallback() {
    @Override
    public void done(ParseObject object, ParseException e) {
         n[0] = object.toString();
    }
});

int viewType = VIEW_TYPE_MARKET_FEED;
if ((position % n[0] == 0) && position > 0) {
    viewType = VIEW_TYPE_AD;
}
return viewType;