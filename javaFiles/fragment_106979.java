List<Minutiae> minuatiaePoints = new ArrayList<Minutiae>(minutiae);

    for(int i = 0; i<minuatiaePoints.size(); i++){
        Minutiae mPoint = minuatiaePoints.get(i);
        Minutiae minPoint = minuatiaePoints.get((i+1) % minuatiaePoints.size());
        int minXDistance = minPoint.getX()-mPoint.getX();
        int minYDistance = minPoint.getY()-mPoint.getY();
        double minDist = Math.hypot(minXDistance, minYDistance);

        List<Minutiae> minDistPoints = new ArrayList<Minutiae>();

        for(int j = 0; j < minuatiaePoints.size(); j++)  // <- you had i++ here!
        {
            if (i == j) {
                continue;
            }

            Minutiae testPt = minuatiaePoints.get(j);
            double dist = Math.hypot(mPoint.getX() - testPt.getX(), mPoint.getY() - testPt.getY());
            if (dist < minDist)
            {
                minDist = dist;
                minDistPoints  = new ArrayList<Minutiae>();
                minDistPoints.add(testPt);
            } else if (dist = minDist) {
                minDistPoints.add(testPt);
            }
        }

        for(Minutae p: minDistPoints){
            g2D.drawLine(mPoint.getX(), mPoint.getY(), p.getX(), p.getY());
        }
    }