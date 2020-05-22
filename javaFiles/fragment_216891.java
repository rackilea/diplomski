void reachDestination()
  {
    println(destination,location);
      //if ((destination.x == location.x) && (destination.y == location.y)) {
      if(dist(destination.x,destination.y,location.x,location.y) < 1){

        if(siteNumber < sites.size() -1){

          siteNumber++; // siteNumber = siteNumber + 1;
          destination = sites.get(siteNumber);
          changeDirection = true;

        }else{

          println("reached final site");

        }
        println("reachDestination");
    }
  }