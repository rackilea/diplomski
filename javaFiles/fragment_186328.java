@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    switch(requestCode) {
        case REQUEST_CODE_B:
            //you just got back from activity B - deal with resultCode
            //use data.getExtra(...) to retrieve the returned data
            break;
        case REQUEST_CODE_C:
            //you just got back from activity C - deal with resultCode
            break;
    }
}