String text ="Don't have an account? Register";
     SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new ForegroundColorSpan(getResources()
                .getColor(R.color.blue)), 23, 31, 0);// i am applying for Register alone. so starting count is 23 and end count is 31.
        ClickableSpan clickableSpan = new SpaceAdjust(text) {
            @Override
            public void onClick(View textView) {
               //here perform your stuff
            }
        };
        spannableString.setSpan(clickableSpan, 23, 31,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);