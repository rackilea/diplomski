@Override
public boolean onQueryTextChange(String newText) {
    newText = newText.toLowerCase();

    // Clear the arrayList first.
    arrayList.clear();

    // If the search text is empty, repopulate the arrayList
    if(newText.length == 0) {
        int count = 0;
        for (String Name :b_name) {
            arrayList.add(new beachesalbum(Name,b_pic[count]));
            count++;
        }
    }

    else {
        int count = 0;
        for (String Name :b_name) {
            if(Name.contains(newText))
                arrayList.add(new beachesalbum(Name,b_pic[count]));
            count++;
        }
    }

    adapter.setFilter(arrayList);

    return true;
}