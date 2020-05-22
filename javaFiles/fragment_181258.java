public class TextFragment extends Fragment{
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle save){
    View v = inflater.inflate(R.layout.fragment_text, container, false);
    TextView t = (TextView)v.findViewById(R.id.text_view);

     Bundle arguments = getArguments();
     boolean x = arguments.getBoolean("data");

     if(x == true){
       t.setText("The box is checked");
     }else{
       t.setText("The box isn't checked");
     }   
     return v;
}