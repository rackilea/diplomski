class TestClipboardServiceActivity : Activity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    startService(Intent(this, MyClipboardService::class.java))

    // Forced the app to be destroyed intentionally.
    finish()
  }
}

/**
 * Clipboard Service. It will clear the clipboard after 60 seconds.
 */
class MyClipboardService : Service() {

  private val mBinder = LocalBinder()

  inner class LocalBinder : Binder() {
    internal val service: MyClipboardService
      get() = this@MyClipboardService
  }

  override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
    Log.i("MyClipboardService", "Received start id $startId: $intent")

    // Remember, this is executed in the main thread.
    Handler().postDelayed(this::clearClipboard, 60000)

    return START_STICKY
  }

  override fun onBind(intent: Intent) = mBinder

  /**
   * Clears the clipboard.
   */
  private fun clearClipboard() {
    val myClipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    myClipboard.primaryClip = ClipData.newPlainText(null, "")
  }
}