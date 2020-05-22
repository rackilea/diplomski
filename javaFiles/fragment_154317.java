List<HomeScreenChatsHelper> mChats = new ArrayList<>();

//filter
List<HomeScreenChatsHelper> result = mChats.stream()
                                     .filter(str->!str.getId().equals(Id)).
                                      .collect(Collectors.toList());