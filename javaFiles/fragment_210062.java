public void changeRecyclerViewPosition() {
TypedValue tv = new TypedValue();
int actionBarHeight = 0;
if (getActivity().getTheme().resolveAttribute(R.attr.actionBarSize, tv, true))
{
actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,getResources().getDisplayMetrics());
}
params.setMargins(0,actionBarHeight, 0, 0);
myrv.setLayoutParams(params);
}