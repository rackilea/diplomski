@Override
protected void onPause() {

    super.onPause();
    editor = preferences.edit();
    editor.putInt("DigitButtonStyle",button1);
    editor.putInt("MemoryButtonStyle", buttonmadd);
    editor.putInt("FunctionButtonStyle", buttoncos);
    editor.commit();
}