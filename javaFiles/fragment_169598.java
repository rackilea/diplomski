Handler handler = new Handler(new Handler.Callback() {
@Override
public boolean handleMessage(Message msg) {
    switch (msg.what) {
        case 1:
          //start activity with intent here

        default:
            break;
    }
    return false;
}
});