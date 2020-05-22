static Get4 _Get4 = NULL;
static FunctionFunc _FunctionFunc2 = NULL;

if(!_Get4)
  _Get4 = (Get4)GetProcAddress(hInstLibrary, "my_Get4");

if(!_FunctionFunc2)
_FunctionFunc2 = (FunctionFunc)GetProcAddress(hInstLibrary, "Function");