// try to print this way then you getting actual value at index becz your try to print String[] object rather each index value so do this way
spinnerArrayList = new ArrayList<String>();
spinnerArrayList.add("");
for (int i=0;i<spinnerArrayList.size();i++){
        String[] splitedValue = spinnerArrayList.get(i).split(",");
        for (int j=0;j<splitedValue.length;j++){
            Log.i(i+" at ArrayIndex "+j+" at splitedIndex Value is >> ",splitedValue[j]);
            String[] splitedValue1 = splitedValue[j].split("~");
            if(splitedValue1.length==1){
                continue;
            }
            for (int k=0;k<splitedValue1.length;k++){
                Log.i(j+" at splitedIndex "+k+" at splited1Index Value is >> ",splitedValue1[k]);
            }
        }

    }