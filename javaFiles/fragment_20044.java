@PostMapping(value = "/saveDetails", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
public void saveDetails(@ModelAttribute FileUploadRequest uploadRequest) {
  try {
      if(CommonUtils.isObjectNullOrEmpty(uploadRequest.getRequestData()) || CommonUtils.isObjectNullOrEmpty(uploadRequest.getProfileImage()) || CommonUtils.isObjectNullOrEmpty(uploadRequest.getAddressImage())){
          logger.warn("Data Should not be null ==>");
      } else {
          detailSaveService.saveOrUpdateDetails(uploadRequest.getProfileImage()), uploadRequest.getAddressImage()),uploadRequest.getRequestData()));
      }

   } catch (Exception e) {
       logger.error("Error while saving profile Details ==>", e);
   }
}