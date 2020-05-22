String guestWholeName = guest.getGuestFirstName() + " " + guest.getGuestLastName();
int wholeNameIndex = indexOf(guestWholeName, searchText);

if (wholeNameIndex > -1) {
    Timber.d("guest name first : guest.getGuestFirstName() %s", guest.getGuestFirstName());
    Timber.d("guest name last : guest.getGuestLastName() %s", guest.getGuestLastName());

    int endPos = wholeNameIndex + searchText.length();

    Spannable spannable = new SpannableString(guestWholeName);
    Typeface firstNameFont = Typeface.createFromAsset(context.getAssets(), "fonts/Graphik-Semibold.otf");
    spannable.setSpan(new CustomTypefaceSpan("", firstNameFont), wholeNameIndex, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    Objects.requireNonNull(guestName).setText(spannable);
} else {
    Objects.requireNonNull(guestName).setText(guestWholeName);
}