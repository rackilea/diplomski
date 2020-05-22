for (FileInfo fileInfo: newTreeFileInfoList){                   
            boolean existsItem = false;

            if (actTreeFileInfoList != null){
                for (FileInfo fileInfo1: actTreeFileInfoList){
                    if (fileInfo.Name.equals(fileInfo1.Name)) {
                        existsItem = true;
                        break;
                    }
                }
            }


            if (!existsItem) {
                addTreeFileInfoList.add(fileInfo);
            }
        }