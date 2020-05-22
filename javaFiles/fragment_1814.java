public void entryPoint1()
{
    commonLogic(() -> { method1(); method2()});
}

public void entryPoint2()
{
   commonLogic(() -> method2());
}