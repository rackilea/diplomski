public class MyFrag extends Fragment{
    private static String KEY_DATA = "_key_data_"
    public static MyFrag newInstance(SomeDataListObject data){
        MyFrag frag = new MyFrag();
        Bundle b = new Bundle();
        frag.setArguments(b);
        // it's important to make your data parcelable and pass it with a Bundle as part of the fragment life-cycle
        b.putParcelableArrayList(KEY_DATA, data);
        return frag;
    }

    // then inside onCreateView
     SomeDataListObject data = getArguments.getParcelableArray(KEY_DATA);
    // ---

}