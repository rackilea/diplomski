uInfo.setFirstName(ds.child(userID).getValue(UserInformation.class).getFirstName()); //set the name
uInfo.setLastName(ds.child(userID).getValue(UserInformation.class).getLastName()); //set the name
uInfo.setAddress(ds.child(userID).getValue(UserInformation.class).getAddress()); //set the name
uInfo.setEmail(ds.child(userID).getValue(UserInformation.class).getEmail()); //set the email
uInfo.setPhoneNo(ds.child(userID).getValue(UserInformation.class).getPhoneNo()); //set the phone_num
uInfo.setRating(ds.child(userID).getValue(UserInformation.class).getRating()); //set the rating