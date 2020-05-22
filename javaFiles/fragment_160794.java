public String[] get_file_names_from_SD() /*Compiler complains here*/
    {
        String state = Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED))
        {
            File root = Environment.getExternalStorageDirectory();
            File dir = new File(root.getAbsolutePath()+"/journal_storage");
            if(dir.exists() & dir.isDirectory())
            {
                return(dir.list());

            }

        }
        else
        {
        Toast.makeText(getActivity(), "Media Mounted Issue", Toast.LENGTH_SHORT).show();
        //--> return null;
        }
    }