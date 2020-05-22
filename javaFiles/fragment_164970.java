@Override
    protected void onPostExecute(List<String> result) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(ncontext, R.layout.seri_view, result);
            Log.i("Adapter", "set up the adapter");
            listView.setAdapter(adapter);
            Log.i("LW", "Weird that we passed that part");
    }