import android.support.v4.app.Fragment;

//If not using "support" fragment, use getFragmentManager()
FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

//you can omit this, Android.R. has some built in anmations.
ft.setCustomAnimations(android.R.anim.slide_in_left, R.animator.fade_out);

//"replace" empties the container of all existing fragments.
ft.replace(container, myFrag, str_SomeID);          

ft.commit();