@Override
    public void onPageSelected(int position) {
        updateTabStyles();
        View v = tabsContainer.getChildAt(position);
        TextView tab = (TextView) v;
        tab.setTextColor(getResources().getColor(R.color.shuffleBlueDark2));
        if (delegatePageListener != null) {
            delegatePageListener.onPageSelected(position);
        }
    }