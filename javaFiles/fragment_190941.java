Employees[] e = NULL;

method()
{
   Employees[] e = new Employees[N]; // this declares a different variable with same name
}

method2()
{
  .. e[0] .. // exception: e was still NULL
}