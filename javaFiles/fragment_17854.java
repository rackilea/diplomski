public FileDisplay(String name) {
    /*  wrong
    the parameter String "name" is reassigned but you need
    to assing the class attribute "filneame", this line is wrong:
    name = filename;
    */

    // correct 
    filename = name;
}