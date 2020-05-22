public void DoMath(ArrayTest a)
{
    Parallel.For(0, Height, (i) =>
    {
        int[] _jagged = jagged[i];
        int[] _a = a.jagged[i];
        for (int j = 0; j < _jagged.Length; j++)
        {
            _jagged[j] *= _a[j];
        }
    });
    //st.Stop();
}