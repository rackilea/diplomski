@Override
public void onViewCreated(View view, Bundle savedInstanceState) {
super.onViewCreated(view, savedInstanceState);

// Init your RecyclerView here
   RecyclerView eventsRecyclerView = (RecyclerView)view.findViewById(R.id.your_viewid);

   EventObject[] objects = (EventObject[]) getArguments().getSerializable(OBJECTS_KEY);
   eventsRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
   eventsRecyclerView.setAdapter(new EventsAdapter(objects));
}