categoryType.setOnItemSelectedListener(new OnItemSelectedListener()
{
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1,
            int position, long id) {
        if(position == 0)
        {
            taxFee.setText("Total tax fee:RM" +  foodFee);
        }else{
            taxFee.setText("Total tax fee:RM" + groceryFee);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        //something
    }

});