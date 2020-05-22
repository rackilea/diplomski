if (Build.VERSION.SDK_INT < 23) {
    myTextView.setTextAppearance(getApplicationContext(), R.style.normalText);
} else{
   myTextView.setTextAppearance(R.style.normalText);
}
myTextView.setBackgroundResource(R.color.normalTextViewColor);