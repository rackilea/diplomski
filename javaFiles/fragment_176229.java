public class MyFragment extends Fragment {
 private int mPosition;
public static MyFragment newInstance(int position) {
   MyFragment fragment = new MyFragment();
   Bundle bundle = new Bundle();
   bundle.putInt("position", position);
   fragment.setArguments(bundle);
   return fragment;
}

public void onCreate(Bundle savedState) {
  super.onCreate(savedState);
  Bundle data = getArguments();
  mPosition = data.getInt("position");
  //do something based on position

}
}