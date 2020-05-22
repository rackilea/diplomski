for (Object obj : selectedFolderInfo) {
        if (obj instanceof FolderInfoData) {
            FolderInfoData folderInfoData = (FolderInfoData) obj;
            FolderInfoRecord folderInfoRecord = folderInfoData.getFolderInforecord();
            folderRecord.add(folderInfoRecord);
            }
              }