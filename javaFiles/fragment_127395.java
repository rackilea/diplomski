View.OnClickListener imageClickedListener = new View.OnClickListener() {
        SharedPreferences pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
        int numClicks = pref.getInt("Total_Clicks", 0);

        @Override
        public void onClick (View v) {
            numClicks++;

            Editor ed = pref.edit();
            ed.putInt("Total_Clicks", numClicks);
            ed.apply();
        }


}

Image1.setOnClickListener(imageClickedListener);
Image2.setOnClickListener(imageClickedListener);
Image3.setOnClickListener(imageClickedListener);