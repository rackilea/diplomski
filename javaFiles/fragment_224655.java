List.setOnItemClickListener(new OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                long arg3) {
            String str1 = List.getItemAtPosition(arg2).toString();
            System.out.println(str1);
            Bundle bucket = new Bundle();
            bucket.putString("my_key", str1);
            // TODO Auto-generated method stub
            Intent launchActivity = new Intent(MainActivityPlanes.this,
                    MainActivityPaper.class);
            launchActivity.putExtras(bucket);
            startActivity(launchActivity);
        }
    });