@Override
public void onBindViewHolder(MyViewHolder holder, int position) {
    String dayInit = days[position];
    String numberInit = numbers[position];
    Long id = getItemId(position);

    boolean isSelected = false;
    if(mSelectionTracker != null) {
        if (mSelectionTracker.isSelected(id)) {
            isSelected = true;
        }
    }

    System.out.println("Here: " + isSelected);
    holder.bind(position, id, dayInit, numberInit, isSelected);
}

@Override
public long getItemId(int position) {
    return position;
}