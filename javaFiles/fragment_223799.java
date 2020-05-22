struct MyJavaClass_Vtable {
    void (*getX)(struct MyJavaClass* this);
    void (*setX)(struct MyJavaClass* this, int value);
};

struct MyJavaClass {
    struct MyJavaClass_Vtable* vtable;
    int x;
};

int MyJavaClass_getX(struct MyJavaClass* this) {
    return this->x;
}
void MyJavaClass_setX(struct MyJavaClass* this, int value) {
    this->x = value;
}

/* A global instance of the vtable for MyJavaClass */
struct MyJavaClass_Vtable MyJavaClassVtableInstance = {
    &MyJavaClass_getX,
    &MyJavaClass_setX
};