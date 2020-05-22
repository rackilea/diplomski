public NoDuplicatesQueueWilson() // Default constructor
{
   items = (T[]) new Object[MAX_QUEUE]; // notice the difference
   front = 0;
   back = MAX_QUEUE-1;
   count = 0;
}