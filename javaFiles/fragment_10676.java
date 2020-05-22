Arrays.sort(myArray,new Comparator<String> ()
    {
        public int compare(String a,String b)
        {
            if(a.equals(b)) // same path/filename
                return 0;
            int aBSCount = a.replaceAll("[^\\\\]","").length();
            int bBSCount = b.replaceAll("[^\\\\]","").length();

            if(aBSCount==bBSCount) // same directory depth
                return a.compareTo(b);

            String[] aSplit = a.split("\\\\");
            String[] bSplit = b.split("\\\\");

            int shortest = Math.min(aSplit.length, bSplit.length);

            for(int x = 0;x < shortest;x++)
            {
                if(x==shortest-1)
                    return aBSCount < bBSCount ? -1 : 1;

                if(!(aSplit[x].equals(bSplit[x])))
                    return aSplit[x].compareTo(bSplit[x]);
            }

            return aBSCount < bBSCount ? -1 : 1;
        }
    });