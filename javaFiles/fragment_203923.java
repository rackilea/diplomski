public class MemCardReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            onMemcardMounted();
        }
        else if (!Environment.getExternalStorageState().equals(Environment.MEDIA_CHECKING)){
            onMemorycardUnMounted();
        }
    }

    private void onMemorycardUnMounted() {}

    private void onMemcardMounted() {}
}