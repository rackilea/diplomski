public MediaDataBox(FileInputStream is) throws IOException {
        super(is);

        //check the mdat header - if not read until mdat if found
        long last32Int = 0;
        long curr32Int = 0;
        long temp;
        while (is.available()>=8) {
            temp = curr32Int = readUint32(is);          

            //test like this to avoid low memory issues
            if((HEADER_TYPE.charAt(0) == (byte)(temp >>> 24)) && 
                    (HEADER_TYPE.charAt(1) == (byte)(temp >>> 16)) &&
                        (HEADER_TYPE.charAt(2) == (byte)(temp >>> 8)) &&
                            (HEADER_TYPE.charAt(3) == (byte)temp)){

                size = last32Int;
                type = curr32Int;
                boxSize = 8;
                break;
            }
            last32Int = curr32Int;
        }
    }