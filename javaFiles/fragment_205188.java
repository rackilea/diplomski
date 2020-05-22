for(int i=0;i<ints1.size();i++)
    {
        dataset.addValue(ints1.get(i), "Good Product", "Hour" + String.valueOf(i+1));
        dataset.addValue(ints2.get(i), "Bad Product", "Hour" + String.valueOf(i+1));
        try{
            dataset2.addValue((ints1.get(i) + ints1.get(i-1) + ints1.get(i-2))/3, "Time", "Hour" + String.valueOf(i+1));
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                dataset2.addValue(null, "Time", "Hour" + String.valueOf(i+1));
            }
    }