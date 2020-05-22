// This will find all "c" elements, and then return all children thereof
$(doc).find("c").children();

// This will return "d", "f", "d", "f", "d", "f":
List<String> tags = $(doc).find("c").children().tags();

// This will return "1", "2", "2, "2", "v", "d":
List<String> texts = $(doc).find("c").children().texts();