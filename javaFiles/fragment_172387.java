public void sendMessage(View view) 
{
    switch (view.getId())   // get the id of the View clicked
    {
         case (R.id.newsButton):
            Intent intent = new Intent(this, NewsActivity.class);
            startActivity(intent);
            break;
        case (R.id.contactButton):
            // assuming ContactActivity.java is an Activity name
            Intent intent = new Intent(view.getContext(), ContactActivity.class);
            startActivity(intent);
            break;
       ...
    }
}