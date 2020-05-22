int[] numbers = new int[]{1,1,2,3,5,8,13,21,34,55};
            int sum=0;
            for(int i=0; i < numbers.length ; i++){        
                 sum = (int) (sum + numbers[i]);
            }
            double average = (double)sum/numbers.length;
            System.out.println("Average value of array elements is : " + average);