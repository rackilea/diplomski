final List<String> contents = new ArrayList<>();
contents.add("<p>HTML content is here!</p>");

final ContentModule module = new ContentModuleImpl();
module.setEncodeds(contents);

entry.getModules().add(module);