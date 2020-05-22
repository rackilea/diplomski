public void populate_array()
{
    for(int i = 0; i < 5; i++)
    {
        for(int j = 0; j < 5; j++)
        {
            int x = rnd.nextInt(5); //0 to 4
            switch(x){
                case 0:{
                    array[i][j] = 'a';
                    break;
                }
                case 1:{
                    array[i][j] = 'b';
                    break;
                }
                case 2:{
                    array[i][j] = 'c';
                    break;
                }
                ...ETC
            }
        }
    }
}