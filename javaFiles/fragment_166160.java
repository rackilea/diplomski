public class MyGameAndroidActivity extends AndroidApplication implements
        ActionResolver {
public void showScoreloop() {
        Intent intent = new Intent(this, EntryScreenActivity.class);
        this.startActivity(intent);
    }
}