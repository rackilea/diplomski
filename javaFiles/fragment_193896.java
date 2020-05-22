int[] numbers = { 1, 2, 3, 4, 5, 6, 8, 10, 11 };

        int start, end;
        for (int i = 0; i < numbers.Length; i++)
        {
            start = numbers[i];

            while (i < numbers.Length - 1 && numbers[i] + 1 == numbers[i + 1])
                i++;

            end = numbers[i];

            if(start == end)
                Console.WriteLine(start);
            else
                Console.WriteLine(start + " - " + end);
        }