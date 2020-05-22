list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
     Intent intent = new Intent(getActivity(),YourSecond.class);
     intent.putExtra("ID",labels.get(position).getId());
     startActivity(intent);
}
});