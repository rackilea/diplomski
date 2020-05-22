try {
    DDVideoEncoder tmpEncoder = new DDVideoEncoder(dir+vidName);

    // write x frames
    Log.d("test", "adding frame");

    try { tmpEncoder.addFrame(path, 50); }
    catch (OutOfMemoryError outOfMemoryError){  Log.d("test", "oom");  break; }
    catch (IOException io) { Log.d("CactusMemChecker", io.getMessage());  break; }
    catch (IndexOutOfBoundsException oob) { Log.d("test", "oob");  break; }

    // finish up
    tmpEncoder.finishEncoding();

} catch (IOException e) { 
    Log.d("test", e.getMessage()); 
    testResult = false; 
} catch (OutOfMemoryError e) { 
    Log.d("test", e.getMessage()); 
    testResult = false; 
} catch (IndexOutOfBoundsException e) { 
    Log.d("test", e.getMessage()); 
    testResult = false; 
}