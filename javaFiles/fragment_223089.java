final LinearLayout container = (LinearLayout) findViewById(R.id.container);

for(int x = 0; x<coffeeSets.length; x++) {


    final View view = getLayoutInflater().inflate(R.layout.custom_list, container, false); // we can set attachToRoot as false  
    TextView tv = (TextView) view.findViewById(R.id.tv1);
    TextView tv2 = (TextView) view.findViewById(R.id.tv2);
    tv.setText(coffeeSets[x].name);
    tv2.setText(coffeeSets[x].price + "\u20BD");

    container.addView(view); // this you missed 
}