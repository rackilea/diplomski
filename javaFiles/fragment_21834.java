String userIDs = "";
for(UserDAO user : originalArrayList) {
  userIDs += user.getId() + ",";
}
userIDs = userIDs.substring(0, userIDs.length-1); //remove last ','

//select * from mixuser where user_id in (list) and partner_id in (list)
MixUserDAO mixUser = (MixUserDAO)myBatisUtil.select(myBatisUtil.MIXUSERDAO, "select", userIDs);