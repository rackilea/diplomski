public static <T> List<T> shellSort(List<T> ul) 
{
    int lcount = ul.size();
    int colcount = 4; // 2^x

    List<T>[] currentCols = (List<T>[])Array.newInstance(List.class, 1);
    currentCols[0] = ul;

    for(; colcount > 0; colcount = (colcount / 2))
    {
        List<T>[] tmpCols = (List<T>[])Array.newInstance(List.class, colcount);

        for(int t1 = 0; t1 < colcount; t1++)
        {
            tmpCols[t1] = new ArrayList<T>();
        }

        int tcur = 0;
        int tcurlvl = 0;
        int ttmp = 0;

        for(int t2 = 0; t2 < lcount; t2++)
        {
            List<T> vcur = currentCols[tcur];
            List<T> vtmp = tmpCols[ttmp];
            vtmp.add(vcur.get(tcurlvl));

            // step to next place
            tcur++;
            ttmp++;
            if(tcur == currentCols.length) { tcur = 0; tcurlvl++; }
            if(ttmp == tmpCols.length) { ttmp = 0; }
        }
    }

    return ul;
}