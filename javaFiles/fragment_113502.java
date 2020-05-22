public void setMessageDetailsExpanded(MessageHeaderItem i, boolean expanded,
            int heightBefore) {
        mDiff = (expanded ? 1 : -1) * Math.abs(i.getHeight() - heightBefore);
        mHeaderItem = i.toString();
        mDetailsExpanded = expanded;
        mHeightBefore = heightBefore;             

}