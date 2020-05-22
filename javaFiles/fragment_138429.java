static import ItemDtoMapper.generateItemDtoFromItem;
static import UserNameExtractor.getLoggedUser;

...

return newItemDto(
        itemDao.saveItemAndReturn(
            newItemDto(
               itemDto, 
               newUser(userService.findByUserName(getLoggedUser())
            ))));