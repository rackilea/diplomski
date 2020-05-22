for (int i = 0; i < response.body().getSoftware(); i++) {
        String textToSet = "" + response.body().getSoftware()[i].status;
        Spannable spannable = new SpannableString(textToSet);
        ForegroundColorSpan fcs = new ForegroundColorSpan(response.body().getSoftware()[i].status ? Color.GREEN : Color.RED);
        spannable.setSpan(fcs, 0, textToSet.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        softwareStatus.append(spannable);
        softwareStatus.append("\n\n");
}