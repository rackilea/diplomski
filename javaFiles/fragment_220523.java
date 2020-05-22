private List<String> mStrings = new ArrayList<String>();

for (int i=0; i<jsonArray.length(); i++)
{
    String url = jsonArray.getJSONArray(i).getString(2);
    mStrings.add("http://www.mywebsite.com/images/" + url);
}