class PagerAdapter extends FragmentStatePagerAdapter {

 HeartRate_Fragment heartRate_fragment;
Calorie_Fragment calorie_fragment;
 Steps_Fragment steps_fragment;

int num;
public PagerAdapter(FragmentManager fm, int x) {
    super(fm);
    this.num=x;
}
@Override
public Fragment getItem(int position) {
    //add new fragment here for homepage viewpager

    switch (position) {

        case 0:
            if(heartRate_fragment == null)
            heartRate_fragment = new HeartRate_Fragment();
            Log.d("flip",1+"");
            return heartRate_fragment;


        case 1:
            if(calorie_fragment == null)
            calorie_fragment = new Calorie_Fragment();
            Log.d("flip",2+"");
            return calorie_fragment;


        case 2:
            if(steps_fragment == null)
            steps_fragment = new Steps_Fragment();
            Log.d("flip",3+"");
            return steps_fragment;


        default:
            return null;

    }

}

@Override
public int getCount() {
    return num;
}

public HeartRate_Fragment getHRFragment()
{
    return heartRate_fragment;
}
public Calorie_Fragment getCalorie_fragment()
{
    return calorie_fragment;
}
public  Steps_Fragment getSteps_fragment()
{
    return steps_fragment;
}