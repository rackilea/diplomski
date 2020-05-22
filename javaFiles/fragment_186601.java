SharedData data = SharedData.getInstance();
data.setAPIKEY("0RUTLH7cqd6yrZ0FdS0NfQMO3lioiCbnH-BpNQQ");//set your map key here
data.setSrc_lat(17);//set your src lat
data.setSrc_lng(78);//set your src lng
data.setDest_lat(18);//set your dest lat
data.setDest_lng(77);//set your dest lng
startActivity(new Intent(YourActivity.this,RoutePath.class));//add RoutePath in your manifeast file