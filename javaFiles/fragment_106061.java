int count = 0;

void dfs(int i)
{
    int k;
    for(k = 0; k < n; k++)
    {
        if(A[i][k] == 1 && !visited[k])
        {
            count++;
            visited[k] = 1;
            dfs(k);
        }
    }
}

for(i=0; i < n;i++)
{
    if(!visited[i])
    {
        count=1;
        visited[i]=1;
        dfs(i);
        // map i with count .. here
    }
}