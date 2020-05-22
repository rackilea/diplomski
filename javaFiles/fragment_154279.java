Microwave()
{
    maxPower = 500;
    currentPower = 500;
    theClock = new Clock();
}

Microwave(int maxp, Clock theClock)
{
    maxPower = maxp;
    currentPower = maxPower;
    //theClock = new Clock(); // you're passing a reference to this already, so by using this call you replace it with a new instance via the default ctor of Clock().
    this.theClock = theClock;
}