Collections.reverse(yourList);  //   <---- reverse the list

RecyclerAdapter recyclerAdapter = new RecyclerAdapter(list,getActivity());
RecyclerView.LayoutManager recyce = new GridLayoutManager(getActivity(),1);
recyclerView.setLayoutManager(recyce);
recyclerView.setItemAnimator( new DefaultItemAnimator());
recyclerView.setAdapter(recyclerAdapter);