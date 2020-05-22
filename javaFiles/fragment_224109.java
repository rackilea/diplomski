int[] val = {25,50,66,75,100,1000,5000,10000,25000};

// create the destination arrays:
int[] train = new int[val.length-1];
int[] test = new int[1];

// initialize the arrays:
test[0] = val[val.length-1];
for (int i = 0; i < val.length-1; ++i)
{
    train[i] = val[i];
}

int timesToIterate = 5;

for (int iteration = 0; iteration < timesToIterate; ++iteration)
{
    evaluate(train, test);

    int i = train.length-1-iteration;
    if (i >= 0) // don't swap if this is the last element in the array
    {
        int tmp = test[0];
        test[0] = train[i];
        train[i] = tmp;
    }
}