private static List<EntityDto> convertEntityDto(List<UserDTO> users) {

    List<EntityDto> newList = new ArrayList<>();

    for (UserDTO usr : users) {

        EntityDto entity = new EntityDto();
        entity.setId(usr.getId());
        entity.setName(usr.getName());

        newList.add(entity);
    }

    return newList;
}