public class CustomOnSelectedListener extends implements OnItemSelectedListener {
    Activity mActivity;

    CustomOnSelectedListener(Activity mActivity) {
         this.mActivity = mActivity;
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
         Toast.makeText(parent.getContext(), 
              "You have changed to : " + parent.getItemAtPosition(pos).toString(),
              Toast.LENGTH_SHORT).show();
         if (mActivity instanceof SunriseSunset) {
             SunriseSunset sunrise = (SunriseSunset) mActivity;
             switch (pos) {
                 case 1: // Assuming Japan is first on your list
                     sunrise.setLocationJapan();
                     break;
                 ... // fill in the rest here
             }
         }
    }

... // rest of CustomOnSelectedListener here

}