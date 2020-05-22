public void save() {
       LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View scrnShotLayout = inflater.inflate(R.layout.screenshot, null);

       screenshotViewCtrl = (ImageView) scrnShotLayout.findViewById(R.id.screenshotView);
       ...//same old
       savePicDialog.setContentView(menuLayout);

       ...//same
   }