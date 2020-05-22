int[] array = {9, 0, 2, -5, 7};
int len = array.Length;

var pairs =
    from i in Enumerable.Range(0, len-1)
    where array[i] > 0
    from j in Enumerable.Range(i+1, len-i-1)
    where array[j] > 0
    let sqrt = (int)Math.Sqrt(array[i] + array[j])
    where array[i] + array[j] == sqrt * sqrt
    select new {
        A = Math.Min(array[i], array[j]),
        B = Math.Max(array[i], array[j])
    };
    //or: select new int[] { ... };