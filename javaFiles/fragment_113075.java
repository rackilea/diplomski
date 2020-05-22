public void onScrolled(RecyclerView recyclerView, int dx, int dy) 
{
    super.onScrolled(recyclerView, dx, dy);

    int currentFirstVisible = yourLayoutManager.findFirstVisibleItemPosition();

    if(currentFirstVisible > firstVisibleInListview)
       Log.i("RecyclerView scrolled: ", "scroll up!");
    else
       Log.i("RecyclerView scrolled: ", "scroll down!");  

    firstVisibleInListview = currentFirstVisible;

}