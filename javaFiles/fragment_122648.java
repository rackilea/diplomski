while (people.moveToNext()) {
    NameIndex = people.getColumnIndex(PhoneLookup.DISPLAY_NAME);

    //check if we have a valid column index
    if (NameIndex != -1) {
        Name = people.getString(NameIndex);

        if(myArr.contains(Name)) {
            // do nothing, as the same String is already in the list
        }
        else {
            myArr.add(Name.toString());
        }
    }    
}