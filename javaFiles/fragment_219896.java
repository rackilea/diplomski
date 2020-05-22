//Progress bar array.
final ProgressBar[] bars = new ProgressBar[numTAs+1];

//Create and initialize the Progress Bar array.
for(int i = 0; i < numTAs + 1; i++){
   //ProgressBar bar = new ProgressBar(this);
   int style = android.R.style.Widget_ProgressBar_Horizontal;
   ProgressBar bar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
   bars[i] = bar;
}

//Build Adapter
ArrayAdapter<ProgressBar> adapter = new ArrayAdapter<ProgressBar>(this, R.layout.layout, bars ){

            @Override
            public View getView(int position, View convertView, ViewGroup parent){

                return bars[position];
            }
        };

        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);

    }