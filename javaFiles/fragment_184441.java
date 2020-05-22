@Override
    public void afterTextChanged(Editable editable) {

        if(edt1.getText().hashCode() == editable.hashCode()){
            if (edt1.length() == 2) {
                edt2.requestFocus();
            }
        }
        else if( edt2.getText().hashCode() == editable.hashCode()){
            if (edt2.length() == 2) {
                edt3.requestFocus();
            }
        }
    }