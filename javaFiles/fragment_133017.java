mCommCode.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                    long id) {
                double finalCommodityValue = 0;
            double argument = ((double) position );

            if(argument < 26){

            finalCommodityValue = argument + 1.00;
            }
        });