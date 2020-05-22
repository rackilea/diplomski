if(s.isEmpty())
        return 0;

     char c = s.charAt(0);

if (Character.isDigit(c)){

            int value=Character.getNumericValue(c);

            return value + intToNum(s.substring(1));
        }

return intToNum(s.substring(1));

}