//pass in your own TextBox when you construct the SB:

TextBox tb = new TextBox();
SuggestBox sb = new SuggestBox(oracle, tb);

//...and later disable the TextBox:

tb.setEnabled(false);