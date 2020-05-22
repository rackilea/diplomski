private void readItems(){
        File filesDir = getActivity().getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            items = new ArrayList<String>(FileUtils.readLines(todoFile));
        }catch (IOException e){
            //Write some logs here... Exception probably happens here
            //But you will never know since you are ignoring it.
            items =new ArrayList<String>();
        }
    }