// a SpannableStringBuilder containing text to display
SpannableStringBuilder sb = new SpannableStringBuilder("You have chosen " + name + " as your contact.");

// create a bold StyleSpan to be used on the SpannableStringBuilder
StyleSpan b = new StyleSpan(android.graphics.Typeface.BOLD); // Span to make text bold

// set only the name part of the SpannableStringBuilder to be bold --> 16, 16 + name.length()
sb.setSpan(b, 16, 16 + name.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make first 4 characters Bold

chosen_contact.setText(sb); // set the TextView to be the SpannableStringBuilder