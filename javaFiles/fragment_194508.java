@Override
public void onResume {
    listener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            //ChatNotificationFragment.ViewPagerAdapter viewPagerAdapter = new ChatNotificationFragment.ViewPagerAdapter(getFragmentManager());
            ChatNotificationFragment.ViewPagerAdapter viewPagerAdapter = new ChatNotificationFragment.ViewPagerAdapter(getChildFragmentManager());
            int unread = 0;
            for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                Chat chat = snapshot.getValue(Chat.class);
                if (Objects.requireNonNull(chat).getReceiver().equals(firebaseUser.getUid()) && !chat.isIsseen()){
                    unread++;
                }
            }

            if (unread == 0){
                viewPagerAdapter.addFragment(new ChatsFragment(), "Chats");
            } else {
                viewPagerAdapter.addFragment(new ChatsFragment(), "("+unread+") Chats");
            }

            viewPagerAdapter.addFragment(new NotificationFragment(), "Notification");
            viewPagerAdapter.addFragment(new SearchFragment(), "Search");
            viewPager.setAdapter(viewPagerAdapter);
            tabLayout.setupWithViewPager(viewPager);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
        }
    }

    // Add the listener to the database reference now. 
    reference.addValueEventListener(listener);
}