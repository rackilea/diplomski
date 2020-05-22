private void decreaseLineOpacity() {
    int position = 0;
    for (Iterator<int[]> iterator = invalidLines.iterator(); iterator.hasNext();) {
        int[] line = iterator.next();
        if (line[0] <= 0) {
            invalidLines.remove(position);
        }
        position++;
    }

    for (Iterator<int[]> iterator = invalidLines.iterator(); iterator.hasNext();) {
        int[] line = iterator.next();
        line[0] -= 10;
        Log.d("Counting", "Opacity: "+ line[0]);
    }
}