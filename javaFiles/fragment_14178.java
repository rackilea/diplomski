// If training is locked, then display the lock picture
if (trainingsList.get(position).isLocked()) {

    holder.lockImage.setBackgroundResource(R.drawable.lock);

    // else display the unlock picture
} else {

    holder.lockImage.setBackgroundResource(R.drawable.unlock);
}