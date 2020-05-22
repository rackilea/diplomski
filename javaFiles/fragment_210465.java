interface X(){

function A();


function B();

}

class A implements X(){
@override
function A(){
//do something
}

function B(){
//do something
}

}


class B extends A{


}
class C extends A{

}  //-> that time your subclass need to implement the functions.