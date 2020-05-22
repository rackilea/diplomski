static void Main(string[] args)
        {
            // The test circuit
            // !((A&&B) || C)
            // A    B   C   Out
            // 1    1   1   0 
            // 1    1   0   0
            // 1    0   1   0
            // 1    0   0   1
            // 0    1   1   0
            // 0    1   0   1
            // 0    0   1   0
            // 0    0   0   1
            // 
            //
            //
            /*     -------     -------
             * A - |     |     |     |
             *     | AND |-----|     |    -------
             * B - | (D) |     |     |    |     |
             *     -------     | OR  |----| NOT |----
             *                 | (E) |    | (F) |
             * C --------------|     |    |     |
             *                 -------    -------
             */

            LogicalInput A = new LogicalInput();
            LogicalInput B = new LogicalInput();
            LogicalInput C = new LogicalInput();
            LogicalAND   D = new LogicalAND();
            LogicalOR    E = new LogicalOR();
            LogicalNOT   F = new LogicalNOT();

            A.SetName("A");
            B.SetName("B");
            C.SetName("C");
            D.SetName("D");
            E.SetName("E");
            F.SetName("F");

            D.AddInput(A);
            D.AddInput(B);

            E.AddInput(D);
            E.AddInput(C);

            F.AddInput(E);

            // Truth Table
            bool[] states = new bool[]{ true, false };
            for(int idxA = 0; idxA < 2; idxA++)
            {
                for(int idxB = 0; idxB < 2; idxB++)
                {
                    for(int idxC = 0; idxC < 2; idxC++)
                    {
                        A.SetState(states[idxA]);
                        B.SetState(states[idxB]);
                        C.SetState(states[idxC]);

                        bool result = F.ComputeOutput();

                        Console.WriteLine("A = {0}, B = {1}, C = {2}, Output = {3}",
                            A.GetState(), B.GetState(), C.GetState(), result.ToString());

                    }
                }
            }
        }
    }