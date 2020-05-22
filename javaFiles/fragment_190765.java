public test(){
    Home home = ...//call the constructor of home to create an instance
    if(null!=home && home.mName=="xxx") {// bad comparison of string and bad way to access an instance variable
        //some code
    }
}