public void onEventMainThread(final AddFriendEvent event) {
            if (!event.isResult())
                return;

            name.setText(event.getUser().get("firstName") + " " + event.getUser().get("lastName"));
            email.setText(event.getUser().getUsername());
            ParseFile file = (ParseFile) event.getUser().get("profileImg");
            if (file != null) {
                Picasso.with(getActivity()).load(file.getUrl()).into(profile);
            }

            addFriendBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    addFriend(event.getUser());
                }
            });

            addFriendBtn.setOnClickListener(null);
            addFriendBtn.setImageResource(R.drawable.ic_action_accept);
        }