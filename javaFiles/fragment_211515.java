public static boolean isSherlock(int arr[])
    {

        int length = arr.length;
        int sum = 0;

        for(int i=0; i<length; ++i)
            sum += arr[i];

        int rightSum = sum-arr[0];
        int leftSum = 0;

        for(int i=0; i<length-1; ++i){

            if(leftSum == rightSum)
                return true;

            leftSum += arr[i];
            rightSum -= arr[i+1];
        }

    if (leftSum == rightSum)
        return true;

    return false;
}