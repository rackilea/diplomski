Query query = entityManager 
            .createQuery("SELECT s.name,s.id FROM Song s,  Playlist p, Composer c WHERE s.id_playlist = p.id AND c.id = p.id_composer "); 

        List results = query.getResultList(); // Fetches list containing arrays of object

        Iterator it = results.iterator();

        while (it.hasNext()) {

            Object[] result = (Object[]) it.next(); // Iterating through the array object

            tempList.add(new BrowserDetailItem ((String) result[0], (Integer) result[1]));
        }

        tempList.size();

        return tempList;