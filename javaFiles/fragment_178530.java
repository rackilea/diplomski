mSignUpButton.setOnClickListener( // Note: I put the new on the next line.
        new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValidator.validate();
            }
        }
);