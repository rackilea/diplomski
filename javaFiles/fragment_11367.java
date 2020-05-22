for(int i=0; i < ((ViewGroup)getView()).getChildCount(); i++) {
            View v = ((ViewGroup)getView()).getChildAt(i);
            if(v instanceof Button) {
                v.setOnClickListener(this);
            }
        }