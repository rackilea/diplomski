String coinText = txtDiamonds.getText().toString();
    char currentChar;
    Spannable spannable = new SpannableString(coinText);
    ForegroundColorSpan color;
    for (int i = 0; i < coinText.length(); i++) {
        currentChar = coinText.charAt(i);
        if (Character.isDigit(currentChar) || ((int) currentChar) == ((int) ','))
            color = new ForegroundColorSpan(Color.YELLOW);
        else
            color = new ForegroundColorSpan(Color.WHITE);
        spannable.setSpan(color, i, i + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
    txtDiamonds.setText(spannable);