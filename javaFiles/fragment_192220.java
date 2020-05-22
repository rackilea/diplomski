SharedPreferences pre = getSharedPreferences("test", sw);
int theme = pre.getInt("theme", sw);

if(theme == 1)
{
    this.mInputView = (KeyboardView) this.getLayoutInflater().inflate(R.layout.input1, null);
}else
{
    this.mInputView = (KeyboardView) this.getLayoutInflater().inflate(R.layout.input2, null);

}
this.mInputView.setOnKeyboardActionListener(this);
this.mInputView.setKeyboard(this.mQwertyKeyboard);
return this.mInputView;