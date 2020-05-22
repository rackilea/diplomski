StringBuilder foo = new StringBuilder("somerandom(actuallynotreallyrandom)characters");
for(int i = 0; i < 10; i++)
{
    foo.append(foo.charAt(0));
    foo.deleteCharAt(0);
}