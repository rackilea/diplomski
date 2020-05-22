public void onFocusChange(View v, boolean hasFocus) {
            if (!hasFocus) {
                EditText cube = (EditText) v;
                Integer tag = (Integer)cube.getTag();
                //code to sort out which cube based on tag
                String s = cube.getText().toString();
                //cubecolor();

            }
        }