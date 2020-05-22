public class Tab1 extends Fragment {

EditTex address,contactNumber;

@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    View v =inflater.inflate(R.layout.tab_1,container,false);

    contactNumber= (EditText)v.findViewById(R.id.editTextcontact);
    address= (EditText)v.findViewById(R.id.editText2);

    contactNumber.setHint("Your ContactNo Plz");
    address.setHint("Your address Plz");

    return v;
   }

   public String getData(){
        return address.getText().toString();
   }
}