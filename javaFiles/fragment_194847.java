JSONArray arr = new JSONArray(response.toString());
for (int i = 0; i < arr.length(); i++)
{
    String drzava = arr.getJSONObject(i).getString("Država");
    System.out.println(drzava);
}