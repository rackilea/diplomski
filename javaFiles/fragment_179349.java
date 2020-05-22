@Override
public void onActivityResult(int requestCode, int resultCode, final Intent data) {

    switch (resultCode) {
        case resultId:
            openFragmentB(); //Fragment transition
            break;
       default:
            super.onActivityResult(requestCode, resultCode, data);
    }
}