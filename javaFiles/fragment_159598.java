String[] arrB = getResources().getStringArray(R.array.mStrArray);
    for (String s : arrB) {
        int i = s.indexOf(searchKeyword);
        if (i >= 0) {
             int position = -1;
             for(int j = 0; j < arrB.length; j++) {
                if(arrB[j] == s) {
                    position = j;
                    break;
                }
        }

        ..
        String[] arrBV = getResources().getStringArray(R.array.mStrArrayValues);

        //finally I got the name of the value :-D
        String mySc = arrBV[position];
        //some code..           
                }
            }