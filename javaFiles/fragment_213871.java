for(i=1;i<=3;i++){
        name[i]= request.getParameter("name"+i);
        place[i] = request.getParameter("place"+i);
        country[i] = request.getParameter("country"+i);
    /*
       it will access the ff.
       "name1" to "name3"
       "place1" to "place3"
       "country1" to "country3"
     */

    }