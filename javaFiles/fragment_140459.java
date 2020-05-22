Iterator<String> itr = arl.listIterator();
            int z=0,x=0,increment=0;
            List<String> strings = new ArrayList<String>();
            while (itr.hasNext()) 
            {
                String data = itr.next();
                list.add(data);
                Log.e("ViewImage5-list all  "+z, data);
                z++;
            }
            // the list "strings" now holds all your strings