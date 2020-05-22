char[] chars = { 'F', 'E', 'L', 'I', 'Z', ' ', 'A', 'N', 'I', 'V', 'E', 'R', 'S', 'A', 'R', 'I', 'O' };
    int length = chars.length;


    for (int line=0;line<=length;line++) {
        //This will print upper part of pyramid
        if(line < length/2){
            String output="";
            int middelVal=length/2;
            for (int i = middelVal - line; i > 0; i--) {
                output=output+" ";
            }
            for (int i = middelVal - line; i <= middelVal + line; i++) {
                output=output+chars[i];
            }
            System.out.println(output);
        }else if(line > length/2){
            //This will print lower part of pyramid
            String output="";
            int middelVal=length/2;
            int nwNum = chars.length-line;
            for (int i = middelVal - nwNum; i > 0; i--) {
                output=output+" ";
            }
            for (int i = middelVal - nwNum; i <= middelVal + nwNum; i++) {
                output=output+chars[i];
            }
            System.out.println(output);
        }
    }