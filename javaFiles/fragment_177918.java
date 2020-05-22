package b;

import a.B;

class B {
     B objectB ; // illegal.. which B, package a or package b..
     b.B objectbB; //legal
     a.B objectaB;  //legal

}