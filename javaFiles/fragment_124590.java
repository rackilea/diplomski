// See here
        adapter.add(new newsItem(title, content, date, time, link, image));
    }  // end loop
} catch(JSONException e){
    Log.i("myTag", e.toString());
}