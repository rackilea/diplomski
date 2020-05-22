@Override
public Places getItem(int position) {
    if(dataSet != null && position < dataSet.size()){
       return dataSet.get(position);
    }
    return null;
}