public static final int INITIAL_TYPE = 0;
public static final int CHANGE_TYPE = 1;
private ArrayList<Integer> mChangedRows = new ArrayList<Integer>();

public void changeRowLayout(int rowPosition) {
   if (mChangedRows.contains(rowPosition)) {
     mChangedRows.remove(mChangedRows.indexOf(rowPosition));
   } else {
     mChangedRows.add(rowPosition);
   }
   notifyDataSetChanged();
}

@Override
public int getItemViewType(int position) {
     if (mChangedRows.size() == 0 || !mChangedRows.contains(position)) {
        return INITIAL_TYPE;
     } else {
        return CHANGE_TYPE;
     }
}

@Override
public int getViewTypeCount() {
    return 2;
}