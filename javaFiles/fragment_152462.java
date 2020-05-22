String text = TextUtils.join(" | ", Arrays.asList(new String[]{"1 Friend", "1 Review", "1 Coupons"}));

        Spannable spannable = new SpannableString(text);

        int index = text.indexOf('|');
        while (index >= 0) {
            spannable.setSpan(new ForegroundColorSpan(Color.BLUE), index, index + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            index = text.indexOf('|', index + 1);
        }
        detailsText.setText(hashText);