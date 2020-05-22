private void updateText() {
    if(getItem() == null){
        text.setValue(""); //$NON-NLS-1$
    }else if (!("").equals(getFormat())) { //$NON-NLS-1$
        text.setValue(type.toString(getItem(), getFormat()));
    } else {
        text.setValue(type.toString(getItem()));
    }
}