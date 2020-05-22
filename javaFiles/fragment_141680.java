int a;
int b;
...
// Atomically change pair (&a, true) to (&b, false).
MarkableReference<int> old = mRef.load();
if(old == MarkableReference(&a, true))
{
    if(mRef.compare_exchange_strong(old, MarkableReference(&b, false)))
    {
        // Successful CAS
    }
}
// 'old' contains other value. (Unsuccessfull CAS)