interface Y { ... }
class SubY implements Y { ... }
DEFINITION CHOICE:
public SubY f() { ... }
OR
public Y f() { ... }
USAGE CHOICE:
...
Y y = f();
OR
SubY y = f(); //maybe with a cast
...