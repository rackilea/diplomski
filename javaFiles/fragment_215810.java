private static int ACT_A = 1;
private static int ACT_B = 2;

private int resultA = 0;
private int resultB = 0;

public void onCreate(Bundle saved) {
    ...
    myTextView.setText("" + (resultA + resultB));
    ...
}