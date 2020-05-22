final TextView et2 = new TextView(this);
        TextView et1 = new TextView(this){
            @Override
            protected void onTextChanged(CharSequence text, int start,
                    int before, int after) {
                // TODO Auto-generated method stub
                super.onTextChanged(text, start, before, after);
                et2.setText(this.getText());
            }
        };