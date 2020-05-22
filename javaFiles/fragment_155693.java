TextView chatOutput = (TextView) findViewById(R.id.textView4);
chatOutput.setText("", BufferType.SPANNABLE);

void updateChatOutput {
    String previous = Html.toHtml((Spannable) chatOutput.getText());
    if (!previous.equals("")) {
        if (previous.substring(0, 13).equals("<p dir=\"ltr\">"))
            previous = previous.substring(13, previous.length()-3); //remove <p dir="ltr"> and </p>
        else
            previous = previous.substring(3, previous.length()-3); //remove <p> and </p>
    }
    chatOutput.setText(Html.fromHtml(message.substring(2, message.length()) + "<br>" +  previous));
}