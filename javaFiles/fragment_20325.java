ArrayList<CustomView> filteredList = new ArrayList<>();
...

private void filter(String constraint) {
    for(CustomView view : AllViews) {
        if (!filteredList.contains(view))
            if (view.toString().toLowerCase().contains(constraint.toLowerCase())) {
                filteredList.add(view);
                break;
            }
        }
    }
    // Do something to add the filteredList to your adapter
    // and show the new list of CustomViews.
}