// println("Visiting " + v);

for(int i = 0; i < adj.length; i++)
{           
    if( adj[v][i] && (visited[i] == 0) )
    {
        visited[i] = counter;
        dfs(i);
    }
}