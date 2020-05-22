try {details = details.replaceAll(" State:(.*)", "\nState:$1");
                                          ^^^^            ^^ 
} catch (Exception e) {}
try {details = details.replaceAll(" Zip:(.*)", "\nZip:$1");
                                        ^^^^          ^^
} catch (Exception e) {}