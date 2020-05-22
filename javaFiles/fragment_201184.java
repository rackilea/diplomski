private boolean updateFood(String id, String name, String category) {
    //getting the specified artist reference
    DatabaseReference dR = FirebaseDatabase.getInstance().getReference("foods").child(uid).child(id);

    //updating artist
    Food food = new Food(id, name, category);
    dR.setValue(food);
    Toast.makeText(getApplicationContext(), "Food Updated", Toast.LENGTH_LONG).show();
    return true;
}

private boolean deleteFood(String id) {
    //getting the specified artist reference
    DatabaseReference dR = FirebaseDatabase.getInstance().getReference("foods").child(uid).child(id);

    //removing artist
    dR.removeValue();

    //getting the tracks reference for the specified artist
    DatabaseReference drNutritions = FirebaseDatabase.getInstance().getReference("nutritions").child(id);

    //removing all tracks
    drNutritions.removeValue();
    Toast.makeText(getApplicationContext(), "Food Deleted", Toast.LENGTH_LONG).show();

    return true;
  }