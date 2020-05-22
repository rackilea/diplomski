for(int i = stateList.size()-1; i >= 0; i--){
        customerInfo state = stateList.get(i);
        if(state.ismStatus())
        {
            //postData(state.getmTrnNo());
            int c = i;
            dbManager.delete_ShipmentDetails(state.getmCustID());
            stateList.remove(i);
            notifyItemRemoved(i);
        }
     }

        adapter.notifyDataSetChanged();