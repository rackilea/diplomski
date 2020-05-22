private class ArrayFilter extends Filter {
     @Override
     protected FilterResults performFiltering(CharSequence prefix) {
    FilterResults results = new FilterResults();
    if (mOriginalValues == null) {
        synchronized (mLock) {
            mOriginalValues = new ArrayList<T>(mObjects);
            //mOriginalValues is no longer null
        }
    }
    if (prefix == null || prefix.length() == 0) {
        synchronized (mLock) {
            ArrayList<T> list = new ArrayList<T>(mOriginalValues);
            results.values = list;
            results.count = list.size();
        }
     } else {
        //filtering work happens here and a new filtered set is stored in newValues
        results.values = newValues;
        results.count = newValues.size();
     }
     return results;
  }
@Override
protected void publishResults(CharSequence constraint, FilterResults results) {
    //noinspection unchecked
    mObjects = (List<T>) results.values;
    if (results.count > 0) {
        notifyDataSetChanged();
     } else {
        notifyDataSetInvalidated();
     }
  }
 }