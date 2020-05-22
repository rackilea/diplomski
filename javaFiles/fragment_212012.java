String temp;
        Scanner sc = new Scanner(str);
        while(sc.hasNext())
        {
            temp = sc.next();
          if(temp.length > 0) {
            wordsByLen[temp.length()-1].add(temp)

        }