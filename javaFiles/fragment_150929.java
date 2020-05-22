public ColorButton(Context context, AttributeSet attrs) {
    super(context, attrs);
    Calculator calc = (Calculator) context; //This Line
    init(calc);
    mListener = calc.mListener;
    setOnClickListener(mListener);
    setOnLongClickListener(mListener);
}