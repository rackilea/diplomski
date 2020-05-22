public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<String> stringList;

    public SectionsPagerAdapter(FragmentManager fm, ArrayList<String> stringArray) {
        super(fm);
        this.stringList = stringArray;
    }

    @Override
    public Fragment getItem(int position) {

        Bundle bundle = new Bundle();
        bundle.putString("YOUR_TEXT", stringList.get(position)); // Get string from stringList using position

        switch (position){
            case 0:
                Tab1Opis tab1 = new Tab1Opis();
                tab1.setArguments(bundle); // Pass text to Tab1Opis fragment                   
                return tab1;

            case 1:
                Tab2Simptomi tab2 = new Tab2Simptomi();
                tab2.setArguments(bundle);
                return tab2;

            case 2:
                Tab3Uzroci tab3 = new Tab3Uzroci();
                tab3.setArguments(bundle);                    
                return tab3;

            case 3:
                Tab4Lijecenje tab4 = new Tab4Lijecenje();
                tab4.setArguments(bundle);
                return tab4;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Opis";
            case 1:
                return "Simptomi";
            case 2:
                return "Uzroci";
            case 3:
                return "Lijecenje";
        }
        return null;
    }
}}