public void checkallbtn_Click(View view)
{
    ListView lv = (ListView)findViewById(R.id.backuplist);
    CheckBox cb;
    try
    {
        for(int i=0;i<lv.getCount();i++)
        {
            cb = (CheckBox)lv.getChildAt(i).findViewById(R.id.checkBox1);
            if(!cb.isChecked())
            {
                cb.setChecked(true);
            }
        }

    }catch(Exception e) {e.printStackTrace();}
}
public void uncheckallbtn_Click(View view)
{
    ListView lv = (ListView)findViewById(R.id.backuplist);
    try
    {
        for(int i=0;i<lv.getCount();i++)
        {
            CheckBox cb = (CheckBox)lv.getChildAt(i).findViewById(R.id.checkBox1);
            if(cb.isChecked())
            {
                cb.setChecked(false);
            }
        }           
    }catch(Exception e) 
    {
        e.printStackTrace();
    }
}