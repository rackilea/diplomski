BottomNavigationMenuView mbottomNavigationMenuView =
            (BottomNavigationMenuView) mBinding.bottomNavigation.getChildAt(0);

    View view = mbottomNavigationMenuView.getChildAt(4);

    BottomNavigationItemView itemView = (BottomNavigationItemView) view;

    View cart_badge = LayoutInflater.from(this)
            .inflate(R.layout.profile_view,
                    mbottomNavigationMenuView, false);

    //// AND THAN SET THE COUNTER BADGE, AS FOLLOW
    ((TextView) cart_badge.findViewById(R.id.notificationsBadge)).setText("5");

    itemView.addView(cart_badge);