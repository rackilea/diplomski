final String plntxt= plainText.getText().toString();
final String noOflines= noOfLines.getText().toString();

...

final int finalLines = lines;
encryptBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // this won't work because plntxt is always empty string
        // and finalLines is always invalid number.
        encryption(plntxt, finalLines);
    }
});