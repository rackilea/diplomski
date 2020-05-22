SharedPrefs prefs = new SharedPrefs(this);  // or getActivity() instead of this if we are in a fragment      
    if(bookmarking){
        bookmark.setImageResource(R.drawable.ic_bookmarked_blue);
        bookmarking=false;
    }
    else{
        bookmarking=true;
        bookmark.setImageResource(R.drawable.ic_bookmark);
    }
    prefs.saveBookingInfo(String.valueOf(bookmarking), String.valueOf(bookmark));