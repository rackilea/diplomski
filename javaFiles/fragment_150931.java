public ColorButton(Context context, AttributeSet attrs, Caculator calculator) {
    super(context, attrs);
    Calculator calc = calculator;
    init(calc);
    mListener = calc.mListener;
    setOnClickListener(mListener);
    setOnLongClickListener(mListener);
}