protected void onPostExecute(ArrayList<Example> examples){
    for(Example i : examples)
    {
        customAdapter.add(i);
    }
    customAdapter.notifyDataSetChanged();
}