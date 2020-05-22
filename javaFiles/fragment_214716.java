int bossV = boss[v];//This is important! Answer why this is needed by yourself.
        for(int z=0;z<_boss.length;z++)
        {
            if(boss[z] == bossV)
               _boss[z]=_boss[u];
        }