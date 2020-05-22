UPDATE lightbulbstatus set status = 0, lastupdate = '2014-11-08 23:50:30+0019'
  WHERE carmake = 'chevy' 
    AND carmodel = 'nova' 
    AND carvin = cfe638e9-5cd9-43c2-b5f4-4cc9a0e6b0ff 
    AND bulbid = 9124f318-8253-4d94-b865-3be07899c8ff 
  IF status = 1 AND lastupdate < '2014-11-08 23:50:30+0019';