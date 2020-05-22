ListView lv = findViewById(R.id.LV);
    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view,int position, long l) {
            switch (position)
            {
                case 1 : 
                {
                    Intent intent = new Intent(getApplicationContext(),OtherClass.class);
                    startActivity(intent);
                }break;
                case 2: 
                {
                    Intent intent = new Intent(getApplicationContext(),OtherClass.class);
                    startActivity(intent);
                }
                break;
            }
        }
    });