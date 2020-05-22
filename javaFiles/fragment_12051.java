holder.check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(holder.check.isChecked()){
            View get=null;
            for (int i=0;i<getCount();i++) {
                if (position == i) {
                    get = getView(i, get, listView1);
                    holder.mobile = (TextView) get.findViewById(R.id.tmobile);
                    String last = holder.mobile.getText().toString();
                    String[] data;

                    Toast.makeText(getContext(), last, Toast.LENGTH_SHORT).show();
                }
            }

            }
            else
            {

            }


        }
    });