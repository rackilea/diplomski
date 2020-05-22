ArrayList<InstagramUserSummary> mutuals = new ArrayList<>();
for (InstagramUserSummary i : followers) {
    for (InstagramUserSummary j : following) {
        if (i.equals(j)) {
            mutuals.add(i);
        }
    }    
}

// here use mutuals to create Adapter
// change this code and use your custom adapter to show users detail in list
ArrayAdapter<InstagramUserSummary> adapter = new ArrayAdapter<>(this,
          android.R.layout.simple_list_item_1, android.R.id.text1, mutuals);