Map<Integer,Integer> map = new HashMap<Integer,Integer>();


       for (int i = 0; i < 6; i++)
         {
             Integer chkNum = myArray[i];
            Integer cnt = (Integer)count(myArray[i], rndNum);
              if(cnt>0)
              {
                  if(map.get(chkNum)==null)
                     map.put(chkNum,1);
                  else
                     map.put(chkNum, map.get(chkNum)+1);
              }

         }

         for (Object key : map.keySet()) 
             System.out.println(map.get(key) + " matches found "+key.toString());