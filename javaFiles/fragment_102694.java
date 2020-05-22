protected void onPostExecute(Void result) {
        listItems.addAll(list);
        adapter.clear();
        adapter.addAll(list);
        adapter.notifyDataSetChanged();
    }