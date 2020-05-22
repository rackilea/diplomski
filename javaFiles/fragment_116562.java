int main(void)
{
    FILE *fp;
    char filename[]=".\\in.txt";
    uint8_t c;
    int length=0, i=0;
    uint8_t *array;

    //Get number of entries in file:
    fp=fopen(filename, "r");
    c= fgetc(fp);
    while(c<255)
    {
        length++;   
        c= fgetc(fp);
    }
    fclose(fp);

    //give array sufficient space
    array = malloc(sizeof(uint8_t)*length);

    fp=fopen(filename, "r");

    //read file into array, and display as hexadecimal
    c = fgetc(fp);
    while(c<255)
    {
        array[i++]= c;
        printf("0x%02x\n", c);
        c = fgetc(fp);  
    }
    fclose(fp);
        getchar();//stop execution to view files (hit any key to exit)
        return 0
}