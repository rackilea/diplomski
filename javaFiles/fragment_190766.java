public test() {
    // assuming home is an instance variable
    if(null!=this.getHome() && this.getHome().mName=="xxx") {// bad comparison of string and bad way to access an instance variable
        //some code
    }
}