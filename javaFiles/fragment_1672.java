String selectedBrand;

lv.setOnItemClickListener(new OnItemClickListener()
{
    @Override 
    public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3)
    { 
        selectedBrand=yourArrayList.get(position).getBrandId();
        new yourAsyncTask(selectedBrand).execute();
    }
});