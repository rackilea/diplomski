private void showButton() {
    yourButton.visibility = View.VISIBLE;
    yourButton.startAnimation(slideUpAnimation);
}

private void hideButton() {
    yourButton.visibility = View.INVISIBLE;
    yourButton.startAnimation(slideDownAnimation);
}