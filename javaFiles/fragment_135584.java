// imported library provides:
public SubY f() { ... }
... // la la la
Y y = f();
useYFunctionality(y);
... // somewhere else that you need SubY functionality
SubY subY = f();
useSubYFunctionality(subY);