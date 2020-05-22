List<Region> regionList = new ArrayList<>();
List<File> fileList = new ArrayList<>(); 

   for (File object: fileList){
                try {
                regionList.add(new Region(object.getName()));
                region.getSelection();
                } catch (Exception e) {

                }
            }