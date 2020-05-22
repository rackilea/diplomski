List<TodayList> lists = list.getTodayList();
if(lists!=null && lists.size>0){
        for (TodayList todayList : lists) {
            Log.i("today", "" + todayList);

        }
        totalPaidFees.setText(list.getTotalFees().toString());
        adapter = new Adapter_TodayFees(lists, getContext());
        recyclerView.setAdapter(adapter);
}
else{
   //Show the message here
 }