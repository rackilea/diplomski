@SuppressWarnings("unlikely-arg-type")
    public static void main (String [] args) {


        int m [] = {-3,23,7,12,4,-44,2,21,3,43} ;

        List<Integer> comArray = Arrays.stream(m).boxed().collect(Collectors.toList());

        System.out.println("Array: " + Arrays.toString(m));
        int[] pos = findNumber(m);
            System.out.println("Array without negatives: ");
                for (int i = 0; i < pos.length; i++) 
                    {
                        System.out.println(pos[i]);         
                    }


        System.out.println("Number of pos num: " + pos.length);
            int sum = 0;
                for (int i : pos)
                    sum += i;
        System.out.println("Sum of pos num: " + sum);


        int [] small = findSmallest(pos);
                System.out.println("Smallest Number: ");
                System.out.println(small[0] + " at pos: " + comArray.indexOf(small[0]));

        int [] big = findBiggest(pos);
                System.out.println("Biggest Number: ");
                System.out.println(big[0] + " at pos: " + comArray.indexOf(big[0]));
        }

        public static int [] findNumber(int[] sum) {
            int num = 0;
            int n [] = new int [sum.length];
                    for(int i = 0; i < sum.length; i++)
                    {
                        if (sum[i] > 0)
                        {
                            n[num] = sum[i];
                            num++;
                        }
                    }
            int [] pos =  new int [num];
                for (int k = 0 ; k < num ; k++)
                {
                    pos[k] = n[k];
                }

            return pos;

        }
    public static int [] findSmallest(int[] pos) {
        int temp;
        for (int i = 0; i < pos.length; i++)
        {
            for (int j = i + 1; j < pos.length; j++)
            {


                if (pos[i] > pos[j])
                    {
                        temp = pos[i];
                        pos[i] =pos[j];
                        pos[j] = temp;
                    }
            }
        }
        return pos;

    }
    public static int [] findBiggest(int[] pos) {
        int temp;
        for (int i = 0; i < pos.length; i++)
        {
            for (int j = i + 1; j < pos.length; j++)
            {


                if (pos[i] < pos[j])
                    {
                        temp = pos[i];
                        pos[i] =pos[j];
                        pos[j] = temp;
                    }
            }
        }
        return pos;

    }

 }