@Override
public int getItemCount() {
    if(mCursor!=null) {
        return mCursor.getCount();
    }else{
        return 0;
    }
}

public void swapCursor(Cursor newCursor) {
    if (newCursor == mCursor) {
        return;
    }

    if (newCursor != null) {
        mCursor = newCursor;
        mRowIDColumn = mCursor.getColumnIndexOrThrow("_id");
        mDataValid = true;
        // notify the observers about the new cursor
        notifyDataSetChanged();
    } else {
        notifyItemRangeRemoved(0, getItemCount());
        mCursor = null;
        mRowIDColumn = -1;
        mDataValid = false;
    }
}