@Override
public boolean onSupportNavigateUp() {
    onBackPressed(); // one inherited from android.support.v4.app.FragmentActivity

    return false;
}