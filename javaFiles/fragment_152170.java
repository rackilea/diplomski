static void Main(string[] args)
    {
        // parse the input, this can probably be done more efficiently
        string input = "1,2,3,###4,5,###6,###7,8,";
        string[] lists = input.Replace("###", "#").Split('#');
        int N = lists.Length;
        int[] length = new int[N];
        int[] indices = new int[N];
        for (int i = 0; i < N; i++)
            length[i] = lists[i].Split(',').Length - 1;

        string[][] element = new string[N][];
        for (int i = 0; i < N; i++)
        {
            string[] list = lists[i].Split(',');
            element[i] = new string[length[i]];
            for (int j = 0; j < length[i]; j++)
                element[i][j] = list[j];
        }

        // solve
        while (true)
        {
            // output current element
            for (int i = 0; i < N; i++) Console.Write(element[i][indices[i]]);
            Console.WriteLine(" ");

            // calculate next element
            int ind = N - 1;
            for (; ind >= 0; ind--)
                if (indices[ind] < length[ind] - 1) break;
            if (ind == -1) break;

            indices[ind]++;
            for (ind++; ind < N; ind++) indices[ind] = 0;
        }
    }