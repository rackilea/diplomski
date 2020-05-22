@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    switch (requestCode) {
    case _ReqCreatePattern:
        if (resultCode == RESULT_OK) {
            String pattern = data.getStringExtra(LockPatternActivity._Pattern);
            ...
        }
        break;
    }
}