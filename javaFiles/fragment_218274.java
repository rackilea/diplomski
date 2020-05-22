public class BkFragment extends Fragment {
public static final String TAG = BkFragment.class.getSimpleName();

public static BkFragment newInstance() {
    return new BkFragment();
}

private Button button;
@Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container,
   Bundle savedInstanceState) {
   View view  = inflater.inflate(R.layout.fragment_bk, container, false);
  setViewRefs(view);
 return view;
}

private void setViewRefs (View view){
button = (Button)view.findViewById(R.id.button);

button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           executeScript();
        }
    });
}

private void  executeScript() {
 try {
    ProcessBuilder pb = new ProcessBuilder(
     "/sdcard/test.sh");
    Process p = pb.start();     // Start the process.
    p.waitFor();                // Wait for the process to finish.
    System.out.println("Script executed successfully");
 } catch (Exception e) {
    e.printStackTrace();
    }
  }
}