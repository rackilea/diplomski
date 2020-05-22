int a,b;

int *x;

void f(void)
{
  ++*x;
}

int main(){
  x = &a;
  f();

  x = &b;
  f();
}