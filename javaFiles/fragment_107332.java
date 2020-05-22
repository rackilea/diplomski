public static final int publicChannel1 = 1;
.....
try {
    JPost.getBroadcastCenter().createPublicChannel(ChannelIds.publicChannel1);
}catch (AlreadyExistsException e){
    e.printStackTrace();
}