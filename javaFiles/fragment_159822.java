mExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

                    @Override
                    public boolean onChildClick(
                            ExpandableListView parent, View v,
                            int groupPosition, int childPosition,
                            long id) {
                        GoCategory(mainMenusList.get(groupPosition)
                                .getPagesList().get(childPosition));
                        return false;
                    }
                });