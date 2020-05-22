inside on onResponse change your code , also convert response in the model
FragmentManager fm = getFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    BookingFragment mFragment = BooingFragment.newInstance(user);
    ft.replace("your fragment container resource id", mFragment);
    ft.commit();

**Fragment class**
public class BookingFragment extends Fragment{
    public static final String USER = "user";
    public static BookingFragment new Instance(User user){
      Bundle bdl = new Bundle();
      bdl.putExtra(USER , user);
      Booking fragment = new BookingFragment();
      fragment.setArgument(bdl);
      return fragment;
     }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup 
      container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.booking_fragment, container, 
        false);
        return view;
    }
}