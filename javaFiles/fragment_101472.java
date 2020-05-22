for (int i=0; i < payloadDTOList.size(); i++) {
    PayloadDTO payloadDTO = (PayloadDTO) payloadDTOList.get(i);       
    if(payloadDTO.getEntType().equals(CommonConstants.CUSTOMENTTYPEROLEID.RES_ROLE_TYPE)) {
      resRoleNameList.add(payloadDTO.getEntName());
    }
}