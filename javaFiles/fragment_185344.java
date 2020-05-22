// NOT JAVA; Java doesn't have this
void foo(int &a) { // Fake pass-by-reference thing
    a = 3;
}

int a = 5;
foo(&a); // Fake pass-by-reference operator
System.out.println(a); // 3