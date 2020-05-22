mutex _mutex;

void f()
{
     unique_lock<mutex> lock(_mutex);
     // access your resource here.
}