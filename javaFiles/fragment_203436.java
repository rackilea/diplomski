there is no need to create another adapter again and again on edit text change.you can refresh list view by just calling notifyDataSetChanged  on adapter.

String searchString = s.toString();
     another_list_class.clear();
     for(int i =0; i< list_view_class.size(); i++){
             String name = list_view_class.get(i).gettitle().toString();
             if(name.contains(searchString))
             {
                   another_list_class.add(list_view_class.get(i));
             }
     }
     adapter.notifyDataSetChanged();


    equalsIgnoreCase returns true if and only if two strings are exactly equal(Ignoring case sensitive);

You can also use startWith in place of contains
One more thing set your adpater with another_list_class arraylist initially.
because in this example we are changing search result in another_list_class .