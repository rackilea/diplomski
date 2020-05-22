for(int i=0; i<cameralist.size(); i++)
    {
     Camera camera=cameralist.get(i)
     Object cameraTotal = portabilityRatedCameraList.get(camera) + easeofdCameraList.get(camera) + usageRatedCameraList.get(camera)
     System.out.println("The total rating of the camera "+camera+" is "+(Double)cameraTotal);
    }