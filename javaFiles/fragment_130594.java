ifstream ifs (f);  // assuming f is a filename
char b[188]; 
int i = 0;
while (ifs.read(b, sizeof(b))) // loop until there's nothing left to read
{
   i = ifs.gcount();   // number of bytes read
   // Code Block
}