@Override
    public void onResume () {
        super.onResume();
        if (sharedPreferenceManager.getCurrentUser().getUserID() != null) {

            edtUserName.setText(sharedPreferenceManager.getCurrentUser().getUserID());
            edtPassword.requestFocus();
            KeyboardHelper.showSoftKeyboard(getContext(), edtPassword);

        } else {
            KeyboardHelper.showSoftKeyboard(getContext(), edtUserName);
        }

    }