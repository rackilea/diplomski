int batchSize = 10;
int start = 0;
int end = batchSize;

int count = list.size() / batchSize;
int remainder = list.size() % batchSize;
int counter = 0;
for(int i = 0 ; i < count ; i ++)
{
    System.out.println("counter   " + counter);
    for(int counter = start ; counter < end ; counter ++)
    {
        //access array as a[counter]
    }
    start = start + batchSize;
    end = end + batchSize;
}

if(remainder != 0)
{
    end = end - batchSize + remainder;
    for(int counter = start ; counter < end ; counter ++)
    {
       //access array as a[counter]
    }
}