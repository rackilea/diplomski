class A { 
    enum N { ONE, TWO, THREE }
    void testSwitch( N e ) { 
        switch( e ) { 
            case ONE : x(); break;
            case TWO : x(); break;
            case THREE : x(); break;
        }
    }
    void testIf( Enum e ) { 
        if( e == N.ONE ) { x(); }
        else if( e == N.TWO ) { x(); }
        else if( e == N.THREE ) { x(); }
    }
    void x(){}
}