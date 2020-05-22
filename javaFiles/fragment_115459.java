public void DoMath(ArrayTest a)
{
    //Stopwatch st = new Stopwatch();
    //st.Start();
    //for (int i = 0; i < Height; i++)
    Parallel.For(0, Height, (i) =>
    {
        for (int j = 0; j < Width; j++)
        {
            jagged[i][j] *= a.jagged[i][j];
        }
    });
    //st.Stop();
    //Console.WriteLine(st.ElapsedMilliseconds);
}