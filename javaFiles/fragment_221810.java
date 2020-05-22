protected static final int TYPE_NORMAL = 0;
protected static final int TYPE_SELECTED = 1;
public int getItemViewType(int position) {
    return isSelected[position] ? TYPE_SELECTED : TYPE_NORMAL;
}

public int getViewTypeCount() {
    return 2;
}