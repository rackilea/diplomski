/* 
I'm using this format:
32 bit signed int                   32 bit signed int                   See below
[number of elements in outer array] [number of elements in inner array] [elements]

[elements] is buildt like
[element(0,0)][element(0,1)]...[element(0,y)][element(1,0)]...

each element is sendt like a 64 bit iee754 "double". If your C compiler/architecture is doing something different with its "double"'s, look forward to hours of fun :)

I'm using a couple non-standard functions for byte-swapping here, originally from a BSD, but present in glibc>=2.9.
*/

/* Calculate the bytes required to store a message of x*y doubles */
size_t calculate_size(size_t x, size_t y)
{
    /* The two dimensions in the array  - each in 32 bits - (2 * 4)*/
    size_t sz = 8;  
    /* a 64 bit IEE754 is by definition 8 bytes long :) */
    sz += ((x * y) * 8);    
    /* and a NUL */
    sz++;
    return sz;
}

/* Helpers */
static char* write_int32(int32_t, char*);
static char* write_double(double, char*);
/* Actual conversion. That wasn't so hard, was it? */
void convert_data(double** src, size_t x, size_t y, char* dst)
{

    dst = write_int32((int32_t) x, dst);    
    dst = write_int32((int32_t) y, dst);    

    for(int i = 0; i < x; i++) {
        for(int j = 0; j < y; j++) {
            dst = write_double(src[i][j], dst);
        }
    }
    *dst = '\0';
}


static char* write_int32(int32_t num,  char* c)
{
    char* byte; 
    int i = sizeof(int32_t); 
    /* Convert to network byte order */
    num = htobe32(num);
    byte = (char*) (&num);
    while(i--) {
        *c++ = *byte++;
    }
    return c;
}

static char* write_double(double d, char* c)
{
    /* Here I'm assuming your C programs use IEE754 'double' precision natively.
    If you don't, you should be able to convert into this format. A helper library most likely already exists for your platform.
    Note that IEE754 endianess isn't defined, but in practice, normal platforms use the same byte order as they do for integers.
*/
    char* byte; 
    int i = sizeof(uint64_t);
    uint64_t num = *((uint64_t*)&d);
    /* convert to network byte order */
    num = htobe64(num);
    byte = (char*) (&num);
    while(i--) {
        *c++ = *byte++; 
    }
    return c;
}