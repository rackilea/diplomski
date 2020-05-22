struct MyJavaClass {
    int x;
};

int MyJavaClass_getX(struct MyJavaClass* this) {
    return this->x;
}
void MyJavaClass_setX(struct MyJavaClass* this, int value) {
    this->x = value;
}