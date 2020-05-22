final Path image = Paths.get("/", "Data", "Cache", "Character", "images", "1.png");
final Path base = Paths.get("/", "Data", "Cache");
System.out.println(image);
System.out.println(base);
final Path relativeImage = base.relativize(image);
System.out.println(relativeImage);