private static int get_wx_inx(String str) {
        if(str.equalsIgnoreCase("木")) {
            return 0;
        } else if(str.equalsIgnoreCase("火")) {
            return 1;
        }else if(str.equalsIgnoreCase("土")) {
            return 2;
        } else if(str.equalsIgnoreCase("金")) {
            return 3;
        } else if(str.equalsIgnoreCase("水")) {
            return 4;
        } else {
            return 0;// write default return here. If every condition goes false then this default will be return.
        }
    }