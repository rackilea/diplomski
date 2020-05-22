public String gE(Object o) {
    if(o instanceof TextInputEditText) {
        return ((TextInputEditText) o).getText().toString();
    }
    else if(o instanceof BootstrapEditText) {
        return ((BootstrapEditText) o).getText().toString();
    }
    else if(o instanceof EditText) {
        return ((EditText) o).getText().toString();
    }
    return null;
}