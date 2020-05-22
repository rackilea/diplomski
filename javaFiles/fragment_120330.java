List<Media> list; // here is a filled list of medias
Set<String> titles; // here is a set of title interseptions we a looking for 
final List<Media> result = new ArrayList<>();
for (Media media: list) {
  if (!list.getTags().isEmpty()){
    Set<String> tagTitles = list.getTags().stream().map(item -> item.getTitle()).filter(title -> titles.contains(title)).distinct().collect(Collectors.toSet());
    if (tagTitles.size() == titles.size()) {
      result.add(media);
    }
  }
}