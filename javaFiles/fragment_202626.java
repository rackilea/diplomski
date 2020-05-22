mButton.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            switch (which) {
                case 0:
                    mTextView.setText("My Name is Hafed");
                    which++;
                    break;
                case 1:
                    mTextView.setText("I'm 18 years old");
                    which++;
                    break;
                case 2:
                    mTextView.setText("I love programming");
                    which=0;
                    break;
            }
        }
    });