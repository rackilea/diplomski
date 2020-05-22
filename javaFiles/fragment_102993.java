final List<OrderPresenter> modelData = new ArrayList<>();
final RecyclerView   recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

OrdersDataAdapter  adapter = new OrdersDataAdapter(modelData, getActivity());
adapter.setMode(Attributes.Mode.Single);
recyclerView.setAdapter(adapter);

OrderRepository.fetchOrders(getActivity(), new DataFetch() {
    @Override
    public void onResponse(ArrayList<OrderPresenter> data) {
         modelData.clear();
         modelData.addAll(data);
        adapter.notifyDataSetChanged();
       // recyclerView.invalidate();

    }
});