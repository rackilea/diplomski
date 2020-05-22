holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            contactArrayList.get(holder.getAdapterPosition()).setSelected(b);
            Log.e("inviteList",String.valueOf(invitationArrayList.size()));
            }
        });