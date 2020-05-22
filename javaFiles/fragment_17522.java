public class OneFragment extends Fragment{


@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_one, container, false);
    final Button button = (Button) root.findViewById(R.id.button1);

    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(getActivity(), LessonOne.class));
        }
    });

    final Button button2 = (Button) root.findViewById(R.id.button2);

    button2.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(getActivity(), LessonTwo.class););
        }
    });

    return root;
  }

}