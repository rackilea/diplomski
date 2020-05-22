// This represents the combination lock with 4 dials
int [] arr = new int [4];

// This represents how many states each dial can be in
int base = 10; // (0-9)

boolean done = false;

while (!done)
{
    // just for printing out the current state of the array
    System.out.println(Arrays.toString(arr));

    int index = 0;

    // get to the first dial that has not reached its max value
    while (index < arr.length && arr[index] == base - 1)
    {
        index++;
    }

    // all dials are at the max value -> we are done
    if (index == arr.length)
    {
        done = true;
    }
    else
    {
        // increase the first dial we found to not have a max value
        arr[index]++;

        // set all dials before it to 0
        for (int i = 0; i < index; i++)
        {
            arr[i] = 0;
        }
    }           
}