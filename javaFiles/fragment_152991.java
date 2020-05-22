@Override
public boolean onCreateOptionsMenu(Menu menu) {
getMenuInflater().inflate(R.menu.action_bar, menu);
setTitle("");
return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
 super.onOptionsItemSelected(item);
 switch(item.getItemId())
 {

case android.R.id.home:
PreferenceActivity.this.onBackPressed(); 
break;


 }
 return true;   
 }