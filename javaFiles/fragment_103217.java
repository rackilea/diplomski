class LIS {

    static int max_lis_length = 0; // stores the final LIS
    static List<Integer> maxArray = new ArrayList<>();

    // Recursive implementation for calculating the LIS
    static List<Integer> _lis(int arr[], int indx)
    {
        // base case
        if (indx == 0) {
            max_lis_length = 1;
            return new ArrayList<>(Arrays.asList(arr[indx]));
        }

        int current_lis_length = 1;
        List<Integer> currList = new ArrayList<>();
        for (int i=0; i< indx; i++)
        {
            // Recursively calculate the length of the LIS ending at arr[i]
            List<Integer> subproblemList = _lis(arr, i);
            int subproblem_lis_length = subproblemList.size();

            // Check if appending arr[indx] to the LIS ending at arr[i] gives us an LIS ending at 
            // arr[indx] which is longer than the previously
            // calculated LIS ending at arr[indx]
            if (arr[i] < arr[indx] && current_lis_length < (1 + subproblem_lis_length)) {
                current_lis_length = 1 + subproblem_lis_length;
                currList = subproblemList;
            }
        }
        currList.add(arr[indx]);

        // Check if currently calculated LIS ending at
        // arr[n-1] is longer than the previously calculated
        // LIS and update max_lis_length accordingly
        if (max_lis_length < current_lis_length) {
            max_lis_length = current_lis_length;
            maxArray = currList;
        }

        return currList;
    }

    // The wrapper function for _lis()
    static int lis(int arr[], int n)
    {    
        // max_lis_length is declared static above 
        // so that it can maintain its value
        // between the recursive calls of _lis()
        List<Integer> r = _lis( arr, n );
        System.out.println(r);

        return max_lis_length;
    }

    // Driver program to test the functions above
    public static void main(String args[]) {        
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
        int n = arr.length;
        System.out.println(lis( arr, n - 1));


    }
};