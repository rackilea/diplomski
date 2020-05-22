LiearLayout parentView = findViewById(R.id.parentView);

            TextInputLayout emailTextInputLayout = new TextInputLayout(this, null, R.style.Widget_MaterialComponents_TextInputLayout_OutlinedBox);

            emailTextInputLayout.setHint("Please Enter Email Address");
            emailTextInputLayout.setBoxBackgroundMode(TextInputLayout.BOX_BACKGROUND_OUTLINE);
            emailTextInputLayout.setBoxCornerRadii(5, 5, 5, 5);
            TextInputEditText edtEmail = new TextInputEditText(emailTextInputLayout.getContext());
            emailTextInputLayout.addView(edtEmail);

            parentView.addView(emailTextInputLayout);


            TextInputLayout passTextInputLayout = new TextInputLayout(this, null, R.style.Widget_MaterialComponents_TextInputLayout_OutlinedBox);

            passTextInputLayout.setHint("Please Enter Password");
            passTextInputLayout.setBoxBackgroundMode(TextInputLayout.BOX_BACKGROUND_OUTLINE);
            passTextInputLayout.setBoxCornerRadii(5, 5, 5, 5);
            TextInputEditText edtPass = new TextInputEditText(passTextInputLayout.getContext());
            passTextInputLayout.addView(edtPass);

            parentView.addView(passTextInputLayout);