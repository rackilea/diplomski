@Override
public Page<ProfileCreditDTO> findProfileBySelectedParameters(String username, Integer gender, Integer profileType, Integer orientation, Boolean online, Double profileCredit, Integer creditMode, Double creditTotal, Pageable pageable) {
    Page<Profile> searchData= profileRepository.findByAllParameters(username, gender, profileType, orientation, online, pageable);
    Page<ProfileCreditDTO> searchProfileData=null;
    if(searchData != null)
        searchProfileData = searchData.map(x -> this.convertProfileToProfileCreditDTO(x, profileCredit, creditMode, creditTotal));
    return searchProfileData;
}