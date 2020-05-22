@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    switch (requestCode) {
        case ACTION_GAME:
            gameover();
            break;
        default:
            break;
    }
}