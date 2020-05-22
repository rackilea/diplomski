boolean stop = false;

void a(){
    //do some stuff
    if(!stop)
    b();
}
void b(){
    // do something
    if(!stop)
    c();
}
void c(){
    // do something
    if(!stop){

    }
}


void stopCallingMethod(){
    stop = true;
}