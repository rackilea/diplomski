@Override
public void onTabSelected(TabLayout.Tab tab) {

    int pos = tab.getPosition();
    for (int i = 0; i < tabLayout.getTabCount(); i++) {
        View aview = tabLayout.getTabAt(i).getCustomView();
        ImageView img = aview.findViewById(R.id.icon);
        if (i == pos) {
            if (isDomestic) 
                img.setImageResource(domesticImagesClicked[i];
            else
                img.setImageResource(abroadImagesClicked[i]; 
         } else {
            if (isDomestic) 
                img.setImageResource(domesticImages[i];
            else
                img.setImageResource(abroadImages[i]; 
          }
      }        
  }