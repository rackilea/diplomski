newsFeed.add(new newsItem(title, content, date, time, link, image));
    }  // end loop
    // notify the adapter to display the new data 
    adapter.notifyDataSetChanged()
} catch(JSONException e){
    Log.i("myTag", e.toString());
}