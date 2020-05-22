spTypePets.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Resources res = getResources();
        String spinner = spTypePets.getSelectedItem().toString();

        switch (position) {
            case 0:
              imagePath = getURLForResource(R.drawable.dog);
              Glide.with(PetsFormActivity.this).load(R.drawable.dog).apply(RequestOptions.circleCropTransform()).into(ivPetImageForm);
                break;
                     ......
            }   
      }

public String getURLForResource (int resourceId) {
    return Uri.parse("android.resource://"+R.class.getPackage().getName()+"/" +resourceId).toString();
 }