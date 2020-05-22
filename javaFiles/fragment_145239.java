Matcher matcher = Pattern.compile("(@[^@\\s]*)")
                         .matcher("test comment @georgios@gsabanti sefse @afa");

List<String> tags = new ArrayList<>();
while (matcher.find()) {
    tags.add(matcher.group());
}

System.out.println(tags);