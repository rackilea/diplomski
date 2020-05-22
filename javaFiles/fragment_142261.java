@Override
 public void setUserVisibleHint(boolean isVisibleToUser) {
     super.setUserVisibleHint(isVisibleToUser);
     if (isVisibleToUser && mainNotification_recyclerView!=null){
         getData(getActivity());
     }
 }



 @Override
 public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
     super.onViewCreated(view, savedInstanceState);
     if (getUserVisibleHint()) {
         getData(getActivity());
     }
 }