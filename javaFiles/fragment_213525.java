@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    getActivity().invalidateOptionsMenu();
    if (resultCode == Activity.RESULT_OK) {

        if (data != null) {
            City a=new City(data.getStringExtra("city"),data.getStringExtra("country"),"/","/","/","/","/");
            listItems.add(a);
            adapter.add(a);
            adapter.notifyDataSetChanged();
            }

        }

    }

}