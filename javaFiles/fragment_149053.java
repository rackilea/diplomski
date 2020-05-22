@Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int position) {

etc...

 holder.check.setOnClickListener(new View.OnClickListener() {

                    @Override
                    //on checkbox click
                    public void onClick(View v) {

                        //pos is the row number that the clicked checkbox exists in
                        Integer pos = (Integer) holder.check.getTag();

                        //if the checkbox is checked
                        if (holder.check.isChecked())

                        {
                            //we want to add the phone number of the checked row into our arraylist.

                            //add the checked number into the arraylist
                            checkedContactsAsArrayList.add(theContactsList.get(pos).getPhone());

                        } else {
                            //remove the checked number from the arraylist
                            checkedContactsAsArrayList.remove(theContactsList.get(pos).getPhone());

                        }