lv.setOnItemClickListener(new OnItemClickListener()
{
        public void onItemClick(AdapterView<?> arg0, View v, int position, long id){
            Intent callintent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:" + phone_arr[position]));
            startActivity(callintent);                    
        }
 });