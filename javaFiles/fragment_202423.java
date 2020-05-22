for (int i = 0; i < jsonarray.length(); i++) {
  JSONObject p = jsonarray.getJSONObject(i);
  ImageView thumbView = new ImageView(getActivity());
  catid = p.getString("categories_id");
  catname = p.getString("categories_name");

  //Here you can use HashMap, Custom Object also
  String catDetailsString = catid + "," + catname;
  tumbView.setTag(catDetailsString);

  thumbView.setOnClickListener(new View.OnClickListener() { 
     public void onClick(View view) { 
           String catDetails = (String) view.getTag();
           String[] catDetailsArray = catDetails.split(",");
           String categoryId = catDetailsArray[0];
           String categoryName = catDetailsArray[1];

          //Passinng Category Id and name to CategoryFragment
          CategoryFragment categoryFragment = CategoryFragment.newInstance(categoryId, categoryName);
          FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, categoryFragment)
                .commit();

      }
   });
  //Your code goes here
 }