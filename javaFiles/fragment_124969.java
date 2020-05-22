private void AddAllDots()
    {
        for(int i = 0 ; i< listView.getChildCount(); i++)
        {
            View v = listView.getChildAt(i);
            ImageView dots = (ImageView) v.findViewById(R.id.ivMandSelection);
            dots.setVisibility(View.VISIBLE);
        }
    }