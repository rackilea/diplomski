public class Tab1Fragment extends Fragment{
    private static final String ARG_URL = "url";
    public Tab1Fragment(){
    }
    public static Tab1Fragment newInstance(String url) {
            Tab1Fragment fragment = new Tab1Fragment();
            Bundle args = new Bundle();
            args.putString(ARG_URL, url);
            fragment.setArguments(args);
            return fragment;
        }
}