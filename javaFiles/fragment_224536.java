SimpleExpandableListAdapter expListAdapter = new SimpleExpandableListAdapter(
            this, createGroupList(), // Creating group List.
            R.layout.group_row, // Group item layout XML.
            new String[] { "Group Item" }, // the key of group item.
            new int[] { R.id.row_name }, // ID of each group item.-Data
                                            // under the key goes into
                                            // this TextView.
            createChildList(), // childData describes second-level
                                // entries.
            R.layout.child_row, // Layout for sub-level entries(second
                                // level).
            new String[] { "Sub Item" }, // Keys in childData maps to
                                            // display.
            new int[] { R.id.grp_child } // Data under the keys above go
                                            // into these TextViews.
    ) {
        @Override
        public View getChildView(int groupPosition, int childPosition,
                boolean isLastChild, View convertView, ViewGroup parent) {
            View v = super.getChildView(groupPosition, childPosition,
                    isLastChild, convertView, parent);

            if (v != null) {
                final String value = "Check Changed for Checkbox in tab: "+ c + ", on Group: " + groupPosition
                        + ", on Child: " + childPosition;
                CheckBox cb = (CheckBox) v.findViewById(R.id.check);
                cb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                    public void onCheckedChanged(CompoundButton arg0,
                            boolean arg1) {
                        Toast toast = Toast.makeText(ExpandableActivity.this, value, 2000);
                        toast.show();
                    }
                });
            }

            return v;
        }
    };
    setListAdapter(expListAdapter); // setting the adapter in the list.