Integer a=200; --> Internally converted to Integer.valueOf(200);
    Integer b=200; // not same as a
    Integer c=20;
    Integer d=20; // same as c

    Integer c=new Integer(20);
    Integer d=new Integer(20);
    c==d --> returns false; because you are comparing references.