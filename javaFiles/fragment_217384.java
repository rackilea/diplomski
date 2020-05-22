List<MyObject1> mySource1 = (List<MyObject1>) session.getAttribute("myAttribute1");
if (mySource1 == null) {
    List<MyObject2> mySource2 = (List<MyObject2>) session.getAttribute("myAttribute2");
    if (mySource2 == null) {
        // ???
    } else {
        // rock and roll
        myMethod2(mySource2);
    }
} else {
    // proceed
    myMethod1(mySource1);
}