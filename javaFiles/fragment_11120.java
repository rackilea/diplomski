public class SeekbarPreference extends DialogPreference implements
        OnSeekBarChangeListener {

    private SeekBar mSeekbar;

    @Override
    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);

        mSeekbar = (SeekBar) view.findViewById(R.id.sb_text_size);
        mSeekbar.setOnSeekBarChangeListener(this);
    }

    public SeekbarPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setDialogLayoutResource(R.layout.setting_textsize_seekbar);
    }

    @Override
    protected void onDialogClosed(boolean positiveResult) {
        if (positiveResult) {
            // save to SharedPrefs, etc
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekbar, int progress, boolean fromUser) {
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}