@Override
public View getView(int position, View convertView, ViewGroup parent) {
    return super.getView(position, convertView, parent);

    if(!thresholdReachedBefore && position > threshold){

        fetchNextDataSet();

    }
}