public static boolean anyEmptyObject(Object[] objects){
        for(int k = 0;k<objects.length; k++){
            if (objects[k].equals(null)){
                return true;
            }
        }
        return false;
    }