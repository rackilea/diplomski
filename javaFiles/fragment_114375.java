void readFile() {

    FILE* fp = fopen("/data/data/example.com/file_test_1.txt","r+");

    if(fp!=NULL)
    {
        // do something
        fclose(fp);
    }
}