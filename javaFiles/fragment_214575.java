fabCall.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                list = (ListView) getActivity().findViewById(R.id.list);
               //first fill the adapter with updated list
                adapter = new ListItemHelper(getActivity(),generateData())
               // then set the adapter
                list.setAdapter(adapter);
                //notify change
                 adapter.notifyDataSetChanged();
                ;

            }
        });