LinearLayout parent = (LinearLayout) findViewById(R.id.linearLayout_item);

for (int i = 0; i != parent.getChildCount(); i++) {
   if (parent.getChildAt(i).getId() == R.id.linearLayout_alias) {
       LinearLayout alias = (LinearLayout) parent.getChildAt(i);
       EditText editAlias = (EditText) alias.getChildAt(0);

       // do what you want with the EditText
   }
}