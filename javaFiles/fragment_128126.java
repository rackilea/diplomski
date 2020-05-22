public class select_fragment extends Fragment {

@Nullable
@Override
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup 
container, @Nullable Bundle savedInstanceState) {

    Button your_button = (Button) getActivity.findViewById(R.id.your_id_button)

    your_button.setOnClickListener(new OnClickListener() {
    public void onClick(View v)
    {
       button_parking();
    } 
    });
    return inflater.inflate(R.layout.fragment_select, null);

    }

    private void button_parking(){
    Intent myIntent = new Intent(getActivity(), parking.class);
    startActivity(myIntent);
}