public static String SortSstring(String input) {
        int []intArr=new int[78];
        for(int i=0;i<input.length();i++)
            intArr[input.charAt(i)-48] ++;
        String OutputString="";
        for(int i=17;i<78;i++){
            OutputString+=String.valueOf(new char[intArr[i]]).replace('\0', (char)(i+48));
        }
        for(int i=0;i<10;i++){
            OutputString+=String.valueOf(new char[intArr[i]]).replace('\0', (char)(i+48));
        }
        return OutputString;
    }
    }