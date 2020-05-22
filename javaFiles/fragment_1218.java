@Override
    protected void onPostExecute(String result) {
        super.onPostExecute();
        // create and set Adapter for ListView here
        CustomListAdapter adapter=
                        new CustomListAdapter(getActivity(), nik,profile); 
        list.setAdapter(adapter);
    }