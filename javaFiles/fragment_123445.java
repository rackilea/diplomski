@Override
public void onSuccess(ArrayList<NewsPOJO> arrayList) {

    this.arrayList1 = arrayList;
    Log.d("arraylist in onSuccess", String.valueOf(arrayList.size()));

    // Make sure your fragment is done view loading before on success.
    RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.rv_news);
    recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
    Log.d("Arraylist1 size", String.valueOf(+arrayList1.size()));
    recyclerView.setAdapter(new MyRecyclerAdapter(this.getActivity(), arrayList1));

}