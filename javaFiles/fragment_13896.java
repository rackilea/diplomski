myTextView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view){
                    //highlight the TextView
                    //myTextView.setTextAppearance(getApplicationContext(), R.style.boldText);
    if (Build.VERSION.SDK_INT < 23) {
       myTextView.setTextAppearance(getApplicationContext(), R.style.boldText);
    } else {
       myTextView.setTextAppearance(R.style.boldText);
    }
     myTextView.setBackgroundResource(R.color.highlightedTextViewColor);
                }
            });