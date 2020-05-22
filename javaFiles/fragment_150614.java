public void myMethod(){
    MyDomainClass myObj = myDao.load(0);
    myDao.save(myObj);
    System.out.println("Saved myObj with myInt=" + myObj.myInt); // myInt=0

    // the handler will do this: myObj.myInt = 1;
    postSaveHandler.handle(myObj);
}