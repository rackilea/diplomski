View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            changeColorBack(textView1);
            changeColorBack(textView2);
            changeColorBack(textView3);
            changeColorBack(textView4);
            switch (v.getId()) {
                case R.id.textView1:
                    changeColor(textView1);
                    break;
                case R.id.textView2:
                    changeColor(textView2);
                    break;
                case R.id.textView3:
                    changeColor(textView3);
                    break;
                case R.id.textView4:
                    changeColor(textView4);
            }

        }
    };

    textView1.setOnClickListener(listener);
    textView2.setOnClickListener(listener);
    textView3.setOnClickListener(listener);
    textView4.setOnClickListener(listener);