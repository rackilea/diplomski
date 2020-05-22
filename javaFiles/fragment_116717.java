for (int i = 0; i < eventsArray.size(); i++) {
                ParseObject eventClass = eventsArray.get(i);
                String title = eventClass.getString("title");
                arrayList.add(title);
    }
    // Once you update your ArrayList you can update the Adapter
    listAdapter.notifyDataSetChanged();