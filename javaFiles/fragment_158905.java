public void deleteEntry() {
    /* get the input */
    SName = JOptionPane.showInputDialog("Enter Name to delete: ");
    /* if no input, nothing to delete */
    if(SName == null) return;
    /* find the name */
    for (int i = 0; i < counter; i++) {
        /* make sure we have an entry*/
                                /* we know SName is not null */
        if (entry[i] != null && SName.equals(entry[i].getName())) {
            /* null out the deleted entry */
            entry[i] = null;
            // break; /* If you know you have unique names, you can leave the for loop now */
        } /* end if */
    } /* end for i*/
}