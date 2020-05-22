public Test_package(){
    long nowMillis = System.currentTimeMillis();

    this.hour = (int)(((nowMillis/1000) /60) / 60) % 24 + 3;
    this.minute = (int)((nowMillis / 1000) /60 ) % 60;
    this.second =(int)(nowMillis /1000) % 60;      
}