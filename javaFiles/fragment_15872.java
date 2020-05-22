int MAX_LENGTH = 10;
        char[] array = "0127".ToCharArray();
        for (int i = 0; i < MAX_LENGTH; i++)
        {
            for (int offset = 0; offset < array.Length; offset++)
            {
                String disp = "";
                for (int j = 0; j <= i; j++)
                {
                    int index = j + offset;
                    while (index >= array.Length)
                        index -= array.Length;
                    disp += array[index];
                }
                Console.WriteLine(disp);
            }
        }