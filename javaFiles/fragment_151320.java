long start = System.currentTimeMillis();
long now = System.currentTimeMillis();
while (now - start > 1000) // While the difference between the two times is less than a second
{
    now = System.currentTimeMillis();
}