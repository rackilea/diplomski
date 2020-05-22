class ObjectClass {
public:
        ObjectClass() {}

};

void myFunction() {
        ObjectClass my_obj(); //memory is handled for you
        ObjectClass * my_dynamic_obj = new ObjectClass();
        delete my_dynamic_obj; //if delete is not called then
        // the pointer my_dynamic_obj will be deleted but the object itself will remain
        return;
}

main() {
        myFunction();
        return 0;
}