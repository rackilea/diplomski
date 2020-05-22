@Override
public int getItemPosition(Object object)
{
    return POSITION_NONE;
}

void delCurrentPageFnc()
{
    int delIdxVar = viewPager.getCurrentItem();

    if(imageListAryVar.size() > 1)
    {
        imageListAryVar.remove(delIdxVar);
        notifyDataSetChanged();
    }
    else finish();
}