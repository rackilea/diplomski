private void showData(DataSnapshot dataSnapshot) {
ArrayList<String> array  = new ArrayList<>();
for(DataSnapshot ds : dataSnapshot.getChildren()){
    UserInformation uInfo = ds.getValue(UserInformation.class);
    array.add(" Full Name : " +uInfo.getName());
    array.add(" Age : " + uInfo.getAge());
    array.add(" Handicap: " + uInfo.getHandicap());
    array.add(" Gender: " + uInfo.getGender());
  }
}