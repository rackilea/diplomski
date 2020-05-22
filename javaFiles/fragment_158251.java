private void setBackupFolderTitle(DriveId id){
        id.asDriveFolder().getMetadata((mGoogleApiClient)).setResultCallback(
            new ResultCallback<DriveResource.MetadataResult>() {
                @Override
                public void onResult(DriveResource.MetadataResult result) {
                    if (!result.getStatus().isSuccess()) {
                        showErrorDialog();
                        return;
                    }
                    Metadata metadata = result.getMetadata();
                    // Set folder title in TextView
                    folderTextView.setText(metadata.getTitle());
                }
            }
        );
    }