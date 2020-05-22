switch (x)
{
case 0:
    // Code here will execute for x==0 only

case 1:
    // Code here will execute for x==1, *and* x==0, because there was no break statement
    break;

case 2:
    // Code here will execute for x==2 only, because the previous case block ended with a break
}