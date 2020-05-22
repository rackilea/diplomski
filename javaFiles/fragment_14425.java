template<typename T>
long Weight(const T& w, int size, const int W)
{
    vector<vector<int>> m(size+1, vector<int>(W+1, 0));

    for(int i = 1; i <= size; ++i)
    {
        for(int j = 0; j <= W; ++j)
        {
            if(w[i-1] > j)
            {
                m[i][j] = m[i-1][j];
            }
            else if((j - m[i-1][j]) < (j - (m[i-1][j - w[i-1]] + w[i-1])))
            {
                m[i][j] = m[i-1][j];
            }
            else
            {
                m[i][j] = m[i-1][j - w[i-1]] + w[i-1];
            }
        }
    }

    return m[size][W];
}