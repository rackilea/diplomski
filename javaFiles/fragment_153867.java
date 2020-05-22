@Override
public void onReceive(Context context, Intent intent) {
    Log.d("Yay", "onReceived called"); // Appears on LogCat.
    plot.setTitle("A Happy Plot"); // Doesn't take effect.
    plot.redraw();
}