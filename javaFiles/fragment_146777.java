//First of all declare a global variables
String globalQuery="";
ArrayList<HashMap<String, String>> globalList = new ArrayList<HashMap<String, String>>();
ListViewAdapter globalListAdapter;

public void afterTextChanged(Editable s) {
 if (s.toString().length() > 0) {
                    // Search
globalQuery=s.toString();
//This method will filter all your categories just calling this method.
filteredList();
                } else {
                    globalQuery="";
//If the text is empty the list all the content of the list adapter
                justListAll();
                }
            }

public void justListAll()
{
    globalAdapter = new ListViewAdapter(MainActivity.this, globalList);
                    listview.setAdapter(adapter);
    setListAdapter(globalAdapter);
    ((ListViewAdapter)globalAdapter).notifyDataSetChanged();
}

public void filteredList()
{
//First of all checks for our globalList is not a null one.
if(globalList!=null)
            {

    ArrayList<HashMap<String, String>> tempList = new ArrayList<HashMap<String, String>>();
//Checks our search term is empty or not.
    if(!globalQuery.trim().equals(""))
    {
        boolean isThereAnyThing=false;
    for(int i=0;i<globalList.size();i++)
    {
//Get the value of globalList that is HashMap indexed at i.
        HashMap<String, String> tempMap=globalList.get(i);
//Now getting all your HashMap values into local variables.
        String rank=tempMap.get(MainActivity.RANK);
        String country=tempMap.get(MainActivity.COUNTRY);
        String population=tempMap.get(MainActivity.POPULATION);
        String url=tempMap.get(MainActivity.URL);
        String flag=tempMap.get(MainActivity.FLAG);
//Now all the core checking goes here for which one of these was typed like rank or country or population .....
                if(rank.regionMatches(true, 0, globalQuery,0, globalQuery.length()) || country.regionMatches(true, 0, globalQuery,0, globalQuery.length()) || population.regionMatches(true, 0, globalQuery,0, globalQuery.length()) || url.regionMatches(true, 0, globalQuery,0, globalQuery.length()) || flag.regionMatches(true, 0, globalQuery,0, globalQuery.length()))
                {
//If anything matches then it will add to tempList
                    tempList.add(tempMap);
                    isThereAnyThing=true;
                }
    }
//Checks for is there anything matched from the ArrayList with the user type search query
    if(isThereAnyThing)
    {
//then set the globalAdapter with the new HashMaps tempList
     globalAdapter = new ListViewAdapter(MainActivity.this, tempList);
                    listview.setAdapter(globalAdapter);
    setListAdapter(globalAdapter);
    ((ListViewAdapter)globalAdapter).notifyDataSetChanged();
    }
    else
    {
//If else set list adapter to null
        setListAdapter(null);
    }
}
else
{
    // Do something when there's no input
    if(globalAdapter==null)
    {
//If no user inputs then it will list everything in the globalList.
justListAll();
    }
    else
    {
         runOnUiThread(new Runnable()
         {
             public void run()
             {

    ((ListViewAdapter)globalAdapter).notifyDataSetChanged();

             }
         });
    }

         }
     // updating listview

            }
}