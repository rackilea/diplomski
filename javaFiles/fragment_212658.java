//Using treemap to sort retweeters according to their followers
 TreeMap<Integer,String> tm = new TreeMap<Integer, String>();
 try{
     for(int k=0;k<10;k++)
         {
             publishProgress(5);
             Log.i(a, "treemap followers"+k);
             u = twitter.showUser(id[k]);
             follower=u.getFollowersCount();
             url=u.getProfileImageURL();
             tm.put(follower,url );
         }
    }
catch(Exception e)
    {
        Log.e(a, e.toString());
    }
Log.i(a, "Done treemap");

 //Reverse the order of the treemap 
 Log.i(a, "Reversing Treemap");
 NavigableMap<Integer,String> reverseTreeMap = tm.descendingMap();
 publishProgress(5);

 //Put treemap values in string
 s=reverseTreeMap.values().toString();
 s=s.replace("[", "");
 s=s.replace("]", "");

     //make array of string s
     s=s.split(",");
  Log.i(a, "Done");