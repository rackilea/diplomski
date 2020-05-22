keystore "/home/ray/raystore"; // make sure you reference the path to the key you generated in the previous step

// A sample policy file that lets a program 
// create demo.ini in user's home directory
// Satya N Dodda

grant SignedBy "company" {
  permission java.util.PropertyPermission 
    "user.home", "read";
  permission java.io.FilePermission 
    "${user.home}/demo.ini", "write";
};