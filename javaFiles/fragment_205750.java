public class Dialog1 extends Dialog {

    int integerI;
    Button button;


    public Dialog1(final Activity activity, final int i, final ModifiedListener listener) {
        super(activity);
        setContentView(R.layout.dialog1);
        integerI = i;

        button = findViewById(R.id.dialog1Button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog2 dialog2 = new Dialog2(activity, integerI);
                dialog2.show();
                closeDialog();
            }
        });

    }

    private void closeDialog() {
        this.dismiss();
    }
}