public class MainActivity extends Activity {
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (level == TRIM_MEMORY_UI_HIDDEN) {
            Context ctx = getApplicationContext();
            Toast.makeText(ctx, "gone", Toast.LENGTH_SHORT).show();
        }
    }
}