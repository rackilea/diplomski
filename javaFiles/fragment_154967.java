TabWidget tabWidget = getTabWidget();

for(int i = 0; i < tabWidget.getChildCount(); i++) {
RelativeLayout tabLayout = (RelativeLayout) tabWidget.getChildAt(i);
tabLayout.setBackgroundDrawable(res.getDrawable(R.drawable.tab_indicator));
}