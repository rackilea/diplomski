mp[position].button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp[position].active = !mp[position].active;
                setIcon(position, mp[position].active);
                notifydatasetchanged();
            }
        });