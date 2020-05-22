Spannable spans = (Spannable) text;
ClickableSpan clickSpan = new ClickableSpan() {
@Override
public void onClick(View widget) {
    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+ url));
}
public void updateDrawState(TextPaint ds) {
    //override link-centric text appearance
}
};
int index = (text.toString()).indexOf(url);
spans.setSpan(clickSpan, index, url.length() + index,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);