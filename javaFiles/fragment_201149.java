Thread currentThread;
switch th)
{
case 0:
    currentThread = new Thread(...);
    break;
// ...
default:
    // unreachable, just to shut up the compiler
    return;
}
currentThread.start();