public class BroadcastReceiver extends android.content.BroadcastReceiver {

    private final BiConsumer<Context, Intent> receiver;

    public BroadcastReceiver(final BiConsumer<Context, Intent> onReceive) {
        receiver = onReceive;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (receiver == null) {
            throw new UnsupportedOperationException("Not yet implemented");
        }
        receiver.accept(context, intent);
    }
}