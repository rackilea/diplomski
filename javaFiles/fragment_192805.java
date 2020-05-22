public class DrawView extends View {

    public Button btnReset;
    public LinearLayout.LayoutParams params;
    public LinearLayout.LayoutParams paramsRadio;
    public RadioGroup btnScale;

 public DrawView(Context context) {
            super(context);

    btnReset = new Button(context);
    btnReset.setText("Clear Screen");

    btnScale = new RadioGroup(context);
    btnScale.setOrientation(RadioGroup.HORIZONTAL);

    params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
    LinearLayout.LayoutParams.WRAP_CONTENT);

   paramsRadio = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
   LinearLayout.LayoutParams.WRAP_CONTENT);