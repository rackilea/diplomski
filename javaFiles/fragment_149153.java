getExpandableListView().setOnItemLongClickListener(new OnItemLongClickListener() {

    Override   
    public boolean onItemLongClick( AdapterView<?> parent, View view, int position, long id) {

        long packedPosition = m_expandableListView.getExpandableListPosition(position);

        int itemType = ExpandableListView.getPackedPositionType(packedPosition); 
        int groupPosition = ExpandableListView.getPackedPositionGroup(packedPosition);
        int childPosition = ExpandableListView.getPackedPositionChild(packedPosition);


        /*  if group item clicked */
        if (itemType == ExpandableListView.PACKED_POSITION_TYPE_GROUP) {
            //  ...
            onGroupLongClick(groupPosition);
        }

        /*  if child item clicked */
        else if (itemType == ExpandableListView.PACKED_POSITION_TYPE_CHILD) {
            //  ...
            onChildLongClick(groupPosition, childPosition);
        }


        return false;
    }
});