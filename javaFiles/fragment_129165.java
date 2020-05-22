public void DataCleanUp()
{
    Log.d("TaDeleted","inside");
    String[] tableCloumn={"User Pointer Column Names",""};
    String[] tableArray={"Class Names Here ",""};



        for(int i=0;i<tableArray.length;i++)
        {
            List<ParseObject> objects=null;
            ParseQuery query=new ParseQuery(tableArray[i]);
            query.setLimit(1000);
            query.include(tableCloumn[i]);
            try {
                objects= query.find();
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if(objects!=null)
                if(!objects.isEmpty())
                {
                    Log.d("Table To Deleted",""+tableArray[i]);
                    for(int j=0;j<objects.size();j++)
                    {
                        if((ParseUser) objects.get(j).get(tableCloumn[i])==null)
                        {
                            try {
                                objects.get(j).delete();
                                Log.d("Deleted", "" + objects.get(j).getObjectId());
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        }
    Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_SHORT).show();
}