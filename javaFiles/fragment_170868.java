import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;


public class MainActivity extends FragmentActivity {

    ...

    private class MainPagerAdapter extends FragmentStatePagerAdapter {
        ...

        @Override
        public Fragment getItem(int position) {
            return new ListRootFragment();
        }

        ...
    }
}