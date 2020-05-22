DialogInterface.OnClickListener closeOnOkClickListener = (dialog, which) -> {
    switch (which){
        case DialogInterface.BUTTON_POSITIVE:
            finish();
            break;
    }
};