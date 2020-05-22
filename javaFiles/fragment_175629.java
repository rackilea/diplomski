protected void sample(int position) {
    if (position < 0) {
        currentPosition = 5;
    } else if (position >= listCount) {
        currentPosition = 0;
    } else {
        currentPosition = position;
    }
}