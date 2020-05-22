//create adapter
    mAdapter = new mAdapter(context, posit, list, checkBoxesStates /* <- fill with false booleans */ );
    recyclerView.setAdapter(mAdapter);

    //check them all
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            for (int i = 0; i <= mAdapter.getItemCount(); i++) {
                checkBoxesStates.add(i, true);
                mAdapter.notifyItemChanged(0); //this updates the adapter
            }
        }
    });