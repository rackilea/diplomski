while ((line = bufRead.readLine()) != null) {

        if (line.equals("")) {
            continue;
        }
        par = line.split("\t");
        i = Integer.parseInt(par[0]);
        j = Integer.parseInt(par[1]);
        if(graph.containsKey(i)){        // if for the given key , an entry exists, fetch the array and add value to it.
            edge = graph.get(i);
            edge.add(j);
            graph.put(i, edge);

        }else{                           //if there is no entry for the key, create a new list and insert values into it.
            edge = new ArrayList();
            edge.add(j);
            graph.put(i, edge);
        }

    }