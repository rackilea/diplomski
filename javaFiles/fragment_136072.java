tambah = (EditText)rootView.findViewById(R.id.about_header);
            tambah.setOnFocusChangeListener(new OnFocusChangeListener() {

                public void onFocusChange(View v, boolean hasFocus) {
                    flag = !flag;
                    if(v == tambah && flag) {
                        //format your text to 1000 here
                    }
                    else if(v == tambah && !flag) {
                        //format your text to 1.000 here
                    }
                }
            });