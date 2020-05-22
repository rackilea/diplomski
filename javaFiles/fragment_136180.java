public class FragmentShapesDemo extends android.support.v4.app.Fragment {

    Button button0;
    Button button1;
    Button button2;

    public FragmentShapesDemo() {
        // Required empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_shapes_demo, container, false);

        button0 = (Button)v.findViewById(R.id.btn_1);
        button1 = (Button)v.findViewById(R.id.btn_2);
        button2 = (Button)v.findViewById(R.id.btn_3);

        button0.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    Toast.makeText(getActivity, "Do Your Work", Toast.LENGTH_SHORT).show();
                }
            });

        button1.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {

                }
            });

        button2.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {

                }
            });

        return v;
    }
}