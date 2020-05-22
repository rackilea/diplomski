arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, lines){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView tv1 = (TextView)super.getView(position, convertView, parent);
                String selectedSymptom = getItem(position);
                if(listItems.contains(selectedSymptom)) {
                    tv1.setTextColor(Color.WHITE);
                    tv1.setBackgroundColor(Color.CYAN);
                }else{
                    tv1.setTextColor(Color.BLACK);
                    tv1.setBackgroundColor(Color.TRANSPARENT);
                }
                return tv1;
            }
        };