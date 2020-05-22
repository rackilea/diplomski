class Test {
 int node = 0;
 static int node1 =10; 

}

class changeNode {

public static void changeNode(){
 new Test().node = somevalue;
//or you need to make node static and change like this
Test.node1 = some value 

}
}