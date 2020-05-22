gridview.setOnItemClickListener(new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

             final Intent intent;
             switch(position)
             {
                 case 0:
           intent =  new Intent(context, FirstActivity.class);
           break;

        case 1:
            intent =  new Intent(context, SecondActivity.class);
            break;
           ...
        default:
           intent =  new Intent(context, DefaultActivity.class);
           break;
     }
    startActivity(intent);


 }
    });