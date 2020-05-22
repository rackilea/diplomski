private String[] mStrings = new String[jsonArray.length()];

for (int i=0; i<jsonArray.length(); i++)
{
    String url = jsonArray.getJSONArray(i).getString(2);
    mStrings[i] = "http://www.mywebsite.com/images/" + url;
}