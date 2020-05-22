ok.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View arg0)
            {
                Intent returnIntent=new Intent();
                b.buildDrawingCache();
                returnIntent.putExtra("BitmapImage", b.getDrawingCache());
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });