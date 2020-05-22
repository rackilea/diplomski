TextInputLayout password = findViewById(R.id......);
EditText editText = password.getEditText();
if (editText == null) {
  return;
}
// Store the current cursor position
final int selection = editText.getSelectionEnd();

//This is core condition. It is the key to know if the password is just visible or not.
if (editText != null
    && editText.getTransformationMethod() instanceof PasswordTransformationMethod) {
  editText.setTransformationMethod(null);
} else {
  editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
}

// And restore the cursor position
editText.setSelection(selection);