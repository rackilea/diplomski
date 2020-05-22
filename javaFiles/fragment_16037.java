FloatingActionButton mFab = new FloatingActionButton.Builder(this)
            .withColor(getResources().getColor(R.color.accent_color))
            .withDrawable(getResources().getDrawable(R.drawable.fab_icon))
            .withSize(72)
            .withMargins(0, 0, 16, 16)
            .create();
mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // DO SOMETHING HERE
            }
        });