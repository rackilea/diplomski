listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
@Override
public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
  Intent in=new Intent(FirstActivity.this,DetailActivity.class);
  startActivity(in)           
            }
        });