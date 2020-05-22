new OnGroupClickListener() {

    @Override
    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

        Object object = parent.getExpandableListAdapter().getGroup(groupPosition);

        ....
        ....

        return true;
    }
}