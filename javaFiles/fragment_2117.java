public class IPOctet {

        private static final String RANGE_SYMBOL = "-";
        int max = 255;
        int min = 0;

        public IPOctet(String stringValue) throws Exception {
            int index = stringValue.indexOf(RANGE_SYMBOL);
            if (index < 0){
                // This octet is a single byte;
                max = str2int(stringValue);
                min = max;
            }else{
                // This octet has a range.
                String[] values = stringValue.split(RANGE_SYMBOL);
                if (values.length != 2) throw new Exception("Invalid Input. Range must be like xx-xx");
                min = str2int(values[0]);
                max = str2int(values[1]);
            }
        }

        public boolean isMatching(IPOctet another) {
            if (max < another.getMinValue()) return false;
            if (min > another.getMaxValue()) return false;
            return true;
        }

        public int getMinValue(){ return min; }
        public int getMaxValue(){ return min; }

        private static int str2int(String input) throws Exception{
            int result;
            try{
                result = Integer.parseInt(input);
            }catch(NumberFormatException nfe){
                throw new Exception("Invalid input. Input is not a number.");
            }
            validate(result);
            return result;
        }

        private static void validate(int input) throws Exception{
            if (input < 0 || input > 255) throw new Exception("Invalid input. Must be between 0 and 255");
        }

    }