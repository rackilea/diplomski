private  void addStatisticalFiles (String fleetName, ArrayList<T> treeFolders, boolean isFleetInfo){
        String fleetPath = env.getRequiredProperty(PROPERTY_NAME_FILESYSTEM_BASEPATH) + fleetName + File.separator + "statistics";
        File statisticalFolder = new File(fleetPath);
        if (statisticalFolder != null && statisticalFolder.exists()){
            if (!isFleetInfo){
                T t =(T)fleetPath;
                treeFolders.add(fleetPath);
                for(String statisticalFile : statisticalFolder.list()){
                    treeFolders.add(fleetPath + File.separator + statisticalFile);
                }
            }else{
              FleetInfo fleetInfo=  new FleetInfo("dir:" + fleetPath, null, null, null);
                T tfleetInfo =(T)fleetInfo;
                treeFolders.add(tfleetInfo );
                for(String statisticalFile : statisticalFolder.list()){
                    treeFolders.add(new FleetInfo("file:" + fleetPath + File.separator + statisticalFile, null, FleetType.file, null));
                }
            }
        }
    }