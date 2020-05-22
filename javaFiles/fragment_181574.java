@Override
    public long getChildId(int groupPosition, int childPosition) {
        int id = 0;
        for (int group = 0; group < groupPosition; group++) {
            id += getChildrenCount(group);
        }
        id += childPosition;
        return id;
    }