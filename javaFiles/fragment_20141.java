public class TimetableSubjectView extends CardView {

    TextView subjectText;

    public TimetableSubjectView(Context context, int column, int row, float columnWeight, String subjectName, int color) {
        super(context);

        GridLayout.Spec rowI = GridLayout.spec(row,1,columnWeight);
        GridLayout.Spec colI = GridLayout.spec(column,1,columnWeight);

        GridLayout.LayoutParams subjectParam =new GridLayout.LayoutParams(rowI,colI);
        subjectParam.setMargins(5,5,5,5);

        setBackgroundColor(color);
        subjectText = new TextView(context);
        CardView.LayoutParams textParams = new CardView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        subjectText.setText(subjectName);
        subjectText.setGravity(Gravity.CENTER);
        subjectText.setLayoutParams(textParams);
        this.addView(subjectText);
        setLayoutParams(subjectParam);
    }


}