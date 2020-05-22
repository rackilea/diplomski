TextView resultTextView = new TextView(this);
final String resultText = LeftText + "  " + RightText;
final SpannableString styledResultText = new SpannableString(resultText);
styledResultText.setSpan(new AlignmentSpan.Standard(Alignment.ALIGN_OPPOSITE)
    , LeftText.length() + 2
    , LeftText.length() + 2 + RightText.length()
    , Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
resultTextView.setText(styledResultText);