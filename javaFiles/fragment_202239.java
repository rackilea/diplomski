File f = new File("D:\\dir_name\\");
    if (f.isDirectory()) {
        String[] list = f.list();
        for (int pos = 0; pos < list.length; pos++) {
            if (list[pos].contains(".")//contains extension
                    && list[pos].lastIndexOf(".") != (list[pos].length() - 1))//point is not last character
            {
                list[pos]=list[pos].substring(0,list[pos].lastIndexOf("."));                       
            }

        }     
    }