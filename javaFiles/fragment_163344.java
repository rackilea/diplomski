textA.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String str="home";
            Spannable spannable =textA.getText();
            if(s.length() != 0) {
                textA.setTextColor(Color.parseColor("#0000FF"));
                ForegroundColorSpan fcs = new ForegroundColorSpan( Color.GREEN);
                String s1 = s.toString();
                int in=0; // start searching from 0 index

// keeps on searching unless there is no more function string found
                while ((in = s1.indexOf(str,in)) >= 0) {
                    spannable.setSpan(
                            fcs,
                            in,
                            in + str.length(),
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    // update the index for next search with length
                    in += str.length();
                }
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    });