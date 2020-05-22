public class QuizOne extends Fragment implements View.OnClickListener {
    ....
  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.quiz, container, false);
        one = (Button) rootView.findViewById(R.id.ones);
        one.setOnClickListener(this);

    // and so on ...


   @Override
   public void onClick(View v) {

       setButtonsGray();
       v.setBackgroundColor(COLOR.Yellow);

   }

   private void setButtonsGray(){
       one.setBackgroundColor(COLOR.Gray);
       two.setBackgroundColor(COLOR.Gray);
       // and so on ...
   }