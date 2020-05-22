for (int i=1; i<=intNumOfPages; i++)
{
    Bundle args = new Bundle();
    args.putInt("num", i);
mTabsAdapter.addTab(bar.newTab().setText("Fragment "+i), TestFrag.class, args);
}