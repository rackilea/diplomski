/**
 * this method used to update list item when broad cast received.
 * @param percentage
 * @param position
 */
public void updateProgress(double percentage, final int position) {
    feedBackVoList.get(position).setPercentage(percentage);
    notifyItemChanged(position);
}