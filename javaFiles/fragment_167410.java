public static double string2double(String strValue) {
        double dblValue = 0;
        if ( strValue != null ) {
            String strResult = "";
            for( int c=0; c<strValue.length(); c++ ) {
                char chr = strValue.charAt(c);

                if ( !(chr >= '0' && chr <= '9'
                   || (c == 0 && (chr == '-' || chr == '+'))
                   || (c > 0 && chr == '.')) ) {
                    break;
                }
                strResult += chr;
            }
            dblValue = Double.parseDouble(strResult);
        }
        return dblValue;
    }