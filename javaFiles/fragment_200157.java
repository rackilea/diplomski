int d=determinant();
int determinant()
{
  int x=a[0][0]*((a[1][1]*a[2][2])-(a[2][1]*a[1][2]));
   int y=-a[0][1]*((a[0][1]*a[2][2])-(a[2][0]*a[1][2]));
 int z=a[0][2]*((a[1][0]*a[2][1])-(a[1][1]*a[2][0]));

    int r=x+y+z;
    return r;
    }