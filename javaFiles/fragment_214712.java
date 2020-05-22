for(int i=n-2;i>=0;i--)
{
    int idx = search(p,p[i].y,i,n-1);
    dp[i] = 1+dp[i+1]%mod;
    if(idx != -1)dp[i]=(dp[i]%mod+dp[idx]%mod)%mod;
}