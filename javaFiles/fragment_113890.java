@Override
public void onUserDetailsAndStatsReceivedListener(UserDetailsAndStats userDetailsAndStats){
    userName = userDetailsAndStats.getUserName();
    tvSlidingMenuUserName.setText(userName);
    avatarPath = userDetailsAndStats.getUserAvatar();
    ivSlidingMenuUserBitmap = BitmapFactory.decodeFile(avatarPath);
    ivSlidingMenuUserAvatar.setImageBitmap(ivSlidingMenuUserBitmap);
}