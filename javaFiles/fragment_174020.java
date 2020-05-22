class ViewHolder {
            TextView userName;
            TextView userDesc;
            ImageView userImage;
            Button userButton;
            TextView friendID;

            ViewHolder(View view) {
                userImage = (ImageView)view.findViewById(R.id.imageview);
                userName = (TextView)view.findViewById(R.id.title);
                userDesc = (TextView)view.findViewById(R.id.mutualTitle);
                userButton = (Button)view.findViewById(R.id.btn);
                friendID = (TextView)view.findViewById(R.id.friendID);
            }
        }