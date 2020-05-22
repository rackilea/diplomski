int count = layout.getChildCount();

    StringBuilder jsonString = new StringBuilder();

    View v = null;
    int j = 1;
    jsonString.append("[");
    for(int i=0; i<count; i++) {
        v = layout.getChildAt(i);

        if(v instanceof Spinner) {
            jsonString.append(j+":"+((Spinner) v).getSelectedItem());

        if (j != count) //if this is not the last spinner
            jsonString.append(",");
        j++;
        }
    }
    jsonString.append("]");