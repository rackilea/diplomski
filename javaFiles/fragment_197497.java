class NumberConstructor
{
    uint inds_sum = 0;
    uint inds_val = 0;
    private uint noOfDigits;
    private uint inds_max;
    uint[] inds = new uint[10];
    uint[] nums = new uint[10];
    private uint[] digs = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public void SelfDesc()
    {
        noOfDigits = 10;

        inds_max = noOfDigits - 1;

        GenerateSelfDescribingNumber(noOfDigits);

        Console.ReadLine();
    }
    private void GenerateSelfDescribingNumber(uint i)
    {
        uint j;

        if (i != 0)
        {
            var diff_sum = noOfDigits - inds_sum;
            var upper_min = inds_sum != 0 ? diff_sum : inds_max;

            j = i - 1;

            uint lower;
            uint upper;

            if (j != 0)
            {
                lower = 0;
                upper = (noOfDigits - inds_val)/j;
            }
            else
            {
                lower = diff_sum;
                upper = diff_sum;
            }

            if (upper < upper_min)
                upper_min = upper;

            for (inds[j] = lower; inds[j] <= upper_min; inds[j]++)
            {
                if (inds[j] < i || nums[inds[j]] < inds[inds[j]])
                {
                    nums[inds[j]]++;
                    inds_sum += inds[j];
                    inds_val += inds[j]*j;
                    uint k;

                    for (k = inds_max; k > j && inds[k] - nums[k] <= i; k--) ;

                    if (k == j)
                        GenerateSelfDescribingNumber(i - 1);

                    inds_val -= inds[j]*j;
                    inds_sum -= inds[j];
                    nums[inds[j]]--;
                }
            }
        }
        else
        {
            for (j = 0; j < noOfDigits; j++)
                Console.Write(digs[inds[j]]);

            Console.WriteLine();
        }
    }
}