mGuillotineAnimation = new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.menu_layout_image), toolbar_menuImage)
        .setStartDelay(RIPPLE_DURATION)
        .setActionBarViewForAnimation(toolbar)
        .setClosedOnStart(true)
        .setGuillotineListener(new GuillotineListener() {
            @Override
            public void onGuillotineOpened() {
                isOpened = true;
            }

            @Override
            public void onGuillotineClosed() {
                isOpened = false;
            }
        })
        .build();