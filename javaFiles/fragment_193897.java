int temp = numbers[0], start, end;
        for (int i = 0; i < numbers.Length; i++)
        {
            start = temp;

            if (i < numbers.Length - 1 )
                // if subsequent numbers are incremental loop further
                if (numbers[i] + 1 == numbers[i + 1])
                    continue;
                // if they are not, number at index i + 1 is a new 'start' for the next iteration
                else
                    temp = numbers[i + 1];

            end = numbers[i];

            if (start == end)
                Console.WriteLine(start);
            else
                Console.WriteLine(start + " - " + end);
        }