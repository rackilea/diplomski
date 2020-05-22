class SinkBroadcastReceiver(private val sink: EventChannel.EventSink) {
    override fun onReceive(context: Context, intent: Intent) {
        val bundle = intent.getExtras()
        if (bundle != null) {
            val steps = bundle.getInt("steps")
            sink.success(steps)
        }
    }
}