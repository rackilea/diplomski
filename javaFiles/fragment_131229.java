arrr = Arrays.copyOf(positionsString.toArray(),positionsString.toArray().length,String[].class);
        if(la!=null) 
            {
            la.clear();
            for (int i = 0; i < arrr.length; i++)
                la.add(arrr[i]);
            la.notifyDataSetChanged();
            Log.e("validatePositionsList", "Odswiezam");
            }