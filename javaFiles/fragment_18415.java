tvText.setSpannableFactory(new Spannable.Factory(){
            @Override
            public Spannable newSpannable(CharSequence source) {
                return (Spannable) source;
            }
        });