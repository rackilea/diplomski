// Class that you have the ArrayList in MainActivity
    ArrayList<String> names = new ArrayList<>();
    names.add("NAME 1");
    names.add("NAME 2");

    ArrayList<String> ratings = new ArrayList<>();
    ratings.add("10");
    ratings.add("8");

    // Create the Bundle and add the ArrayLists as serializable
    Bundle bundle = new Bundle();
    bundle.putSerializable("NAMES", names);
    bundle.putSerializable("RATINGS", ratings);

    // Start new intent with ArrayList Bundle passed in
    Intent intent = new Intent(this, ActivityTwo.class);
    intent.putExtra("KEY", bundle);
    startActivity(intent);