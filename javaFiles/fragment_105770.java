String firstString = "Current applications activation status:\n";
    String ishacked = "Not active --> invalid license!";
    String totalString = "Current applications activation status:\n Not active --> invalid license!";




    Spannable sptext = new SpannableString(totalString);
    sptext.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorAccent)),String.valueOf(firstString).length(),totalString.length(), 0);
    textView.setText(sptext);