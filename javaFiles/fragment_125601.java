@Override
public Page<ProfileCreditDTO> findProfileBySelectedParameters(String username, Integer gender, Integer profileType, Integer orientation, Boolean online, Double profileCredit, Integer creditMode, Double creditTotal, Pageable pageable) {
    Page<Profile> searchData= profileRepository.findByAllParameters(username, gender, profileType, orientation, online, pageable);
    Page<ProfileCreditDTO> searchProfileData=null;
    if(searchData != null)
        searchProfileData = searchData.map(x -> this.convertProfileToProfileCreditDTO(x, profileCredit, creditMode, creditTotal));

    List modifiedAppList = searchProfileData.getContent().stream().filter(v -> v !=null).collect(Collectors.toList()); //Will filter your search result and put it into a list

    Page<ProfileCreditDTO> filteredList = new PageImpl<>(modifiedAppList, new PageRequest(0, searchProfileData.getSize()), searchProfileData.getTotalElements()); //Will put your filtered list back into page

    return  filteredList; //Returns filtered result

}