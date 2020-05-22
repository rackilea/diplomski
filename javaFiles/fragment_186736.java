// borland GDI clear screen
Canvas->Brush->Color=clBlack;
Canvas->FillRect(ClientRect);
// easy access to RGB channels
union _color
    {
    DWORD dd;
    BYTE db[4];
    } c0,c1,c;
//    0x00BBGGRR
c0.dd=0x000000FF; // Red
c1.dd=0x00FF0000; // Blue
int x,y,t0,t1;
for (x=0,y=ClientHeight/2;x<ClientWidth;x++)
    {
    t0=x;
    t1=ClientWidth-1-x;
    c.db[0]=((DWORD(c0.db[0])*t0)+(DWORD(c1.db[0])*t1))/(ClientWidth-1);
    c.db[1]=((DWORD(c0.db[1])*t0)+(DWORD(c1.db[1])*t1))/(ClientWidth-1);
    c.db[2]=((DWORD(c0.db[2])*t0)+(DWORD(c1.db[2])*t1))/(ClientWidth-1);
    c.db[3]=((DWORD(c0.db[3])*t0)+(DWORD(c1.db[3])*t1))/(ClientWidth-1);
    Canvas->Pixels[x][y]=c.dd;
    }