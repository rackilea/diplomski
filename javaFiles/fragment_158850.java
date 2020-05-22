if (mTime < seen) { //// HERE
                        contentValues.put(KEY_SEEN, "Yes"); //Change the value of newData(which is actually your old value) by incrementing
                    long returnVariable = db.update(TABLE_CHAT_DATA, contentValues, null, null);
                   } /// AND HERE
                    if (returnVariable == -1) {
                        Toast.makeText(getApplication(), "Nope", Toast.LENGTH_LONG).show();
                        //-1 means there was an error updating the values
                    } else {
                        Toast.makeText(getApplication(), "SEEEEEEN", Toast.LENGTH_SHORT).show();
                    }