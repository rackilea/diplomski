public class TicketFragment extends Fragment {

public Button strandard;
public Button premium;
public Button vip;
public View rootview;


@Nullable
@Override
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    rootview = inflater.inflate(R.layout.fragment_ticket, container, false);

openMainPage();
 return rootview;

}

public void openMainPage(){
    strandard = (Button)rootview.findViewById(R.id.strandard);
    strandard.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(getActivity(), Payment.class);
            startActivity(intent);

        }
    });
}
}