if (adapter == null) {
   adapter = new GridViewAdapter...
   gridView.setAdapter(adapter)
}

// list refers the list inside in your adapter
list.addAll(newList); // or do your implementation
adapter.notifyDataSetChanged();