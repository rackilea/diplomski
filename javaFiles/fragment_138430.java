ItemDao daoToSave = newItemDto(
    newItemDto,
    newUser(userService.findByUserName(getLoggedUser())
));

return newItemDto(itemDao.saveItemAndReturn(daoToSave));