@Override
public void onClick(View v) {
    if(cardView.isEnabled()) {
        cardView.setEnabled(false); 
        // do other things like writing to SharedPreferences and changing bg colors.
    } else {
        // set background colors 
        cardView.setCardBackgroundColor (Color.parseColor ("#ffffff"));
        textView.setTextColor (Color.parseColor ("#2b434f"));
    }
}