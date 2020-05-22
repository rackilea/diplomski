public class SampleFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, 
                                    Bundle savedInstanceState) {
               View view = inflater.inflate(R.layout.frag_layout, container, false);
               view.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                       et.clearFocus();
                       return true;
                    }
               });
               return view;
        }

    }