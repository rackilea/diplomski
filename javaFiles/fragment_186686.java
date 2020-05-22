FileInputStream fin = null;
try {
    fin = ...
    //more code goes here...
} catch (...) {
    //exception handling...
} finally {
    if (fin != null) {
        fin.close(); //fin is not null, at least the JVM could close it
    }
}