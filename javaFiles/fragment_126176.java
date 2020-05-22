for(int i = 0;i<R-r;i++)//obvious
    {
      for(int j = 0; j<r;j++ )//obvious
        {
          //if string found put in map(row at which found,column at whch found)
          if(G[i].indexOf(P[j])>=0)//string found
            {
              rowCol.put(i,G[i].indexOf(P[j]));
            }
        }
    }