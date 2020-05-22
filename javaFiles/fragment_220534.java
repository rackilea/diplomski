if (position == 0) {
    return VIEW_TYPE_HEADING;
} else {
    int currentGroupId = getCursorAtPosition(position).getInt(0);
    int previousGroupId= getCursorAtPosition(position - 1).getInt(0);
    return currentGroupId != previousGroupId ? VIEW_TYPE_HEADING : VIEW_TYPE_ITEM;
}