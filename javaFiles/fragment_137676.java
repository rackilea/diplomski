((MatchingContact) viewHolder).check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           // ((MatchingContact) viewHolder).check.setOnClickListener(new CompoundButton.OnClickListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                    //pos is the row number that the clicked checkbox exists in
                    Integer pos = (Integer) ((MatchingContact) viewHolder).check.getTag();

                    //set the value of the checkbox accordingly onCheckedChange,
                    //to true or false
                    theContactsList.get(pos).setSelected(isChecked);

                    if(isChecked == true ) {
                        Toast.makeText(context_type, theContactsList.get(pos).getPhone() + " clicked!", Toast.LENGTH_SHORT).show();

                    }

                    else {
                        Toast.makeText(context_type, theContactsList.get(pos).getPhone() + " unclicked!", Toast.LENGTH_SHORT).show();

                    }
                    //Toast.makeText(context_type, theContactsList.get(pos).setSelected(isChecked), Toast.LENGTH_SHORT).show();


                }
            });