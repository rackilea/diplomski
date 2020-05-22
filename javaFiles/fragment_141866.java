void f()
{
    int x = 123; // <- located in stack
}

int x; // <- located in heap
void f()
{
    x = 123  
}