if(PROJECT.equals(type)|| STORY.equals(type) || STORY.equals(DEVELOPER)){
  createdItem = new AggregateItem(name, desc, value);
}else if (STORY_DEVELOPER.equals(type)){
  createdItem = new SingleItem(name, value, child);
}else{
  createdItem = null;
}