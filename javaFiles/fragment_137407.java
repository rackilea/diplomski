View oldView;
public void setFoodItemSortType(View view)
{

    if(oldView != null)
    {
       oldView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
    }

    view.setBackgroundColor(getResources().getColor(R.color.colorAccent));
    oldView = view 
    this.LoadData();
}