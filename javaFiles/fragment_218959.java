ExpandableListView mExpandableListView = (ExpandableListView) findViewById(R.id.exListview);
int count = viewAdapter.getGroupCount();
for (int position = 1; i <= count; position++)
{
    mExpandableListView.expandGroup(position - 1);
}