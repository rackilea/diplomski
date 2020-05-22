public class CustomDailog extends DialogFragment {

private View view;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.addon_dialog, container);

    getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
    getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
    getDialog().setCancelable(true);
    getDialog().getWindow().setGravity(Gravity.TOP);

    return view;
}

@Override
public void onActivityCreated(Bundle arg0) {
    super.onActivityCreated(arg0);

    DisplayMetrics metrics = getResources().getDisplayMetrics();
    int screenWidth = (int) (metrics.widthPixels * 0.95);
    int screenHeight = (int) (metrics.heightPixels * 0.95);

    getDialog().getWindow().setLayout(screenWidth, screenHeight);

    android.support.v4.view.ViewPager addonsviewpager = (android.support.v4.view.ViewPager) view.findViewById(R.id.addonsviewpager);
}