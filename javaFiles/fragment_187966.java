btnIndicator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExpandableListView mExpandableListView = (ExpandableListView) mParetn;
                if(mExpandableListView.isGroupExpanded(mGroupPosition)){
                    mExpandableListView.collapseGroup(mGroupPosition);
                }else{
                    mExpandableListView.expandGroup(mGroupPosition);
                }
            }
        });