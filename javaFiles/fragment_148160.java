File path = new File(path); //path to your folder. eg. C:\\P4logs
for(File f: path.listFiles()) { // this loops through all the files + directories
    if(f.isFile()) { // checks if it is a file, not a directory.
                     // most basic check. more checks will have to be added if 
                     // you have other files you don't want read. (like non log files)
        try (BufferedReader br = new BufferedReader(new FileReader(f.getAbsolutePath()))) { 
        // gets the full path of a file. so "C:\\P4logs\\out.log.2012-12-26"
            //do stuff
        }
    }
}