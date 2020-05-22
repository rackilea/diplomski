path=getExtSdCardPath(con);
if(path!=null)
    {  
        if(new File(path).getPath().equal(Environment.getExternalStorageDirectory().getPath())) // This line give null "Null Pointer exception"
        {
            return  null;
        }
        return path;
    }