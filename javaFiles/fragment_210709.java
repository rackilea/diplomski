while ((ze = zin.getNextEntry()) != null) { 
    Log.v("Decompress", "Unzipping " + ze.getName()); 
    if(ze.isDirectory()) { 
        _dirChecker(ze.getName()); 
    } else {
        if (ze.getName() == desiredFile) {
            byte[] bytes= new byte[ze.getSize()];
            zin.read(bytes, 0, bytes.length);
            strUnzipped= new String( bytes, "UTF-8" );
            /* Removing this as it is easier to just read all the bytes in at once
            InputStreamReader isr= new InputStreamReader(zin, "UTF-8");
            char c= 0;
            for (char c = isr.read(); c != -1; c = isr.read()) {
            strUnzipped += c;
            } 
            */
        }
        zin.closeEntry(); 
    }
}