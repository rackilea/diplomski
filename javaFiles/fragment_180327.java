String str = "00:0qwe8.0 donald controller duck [02009&123@##]: Some more sring here Model number 420 Family [Super-cool] [15b31013^^@#][15b:31013]";
Pattern pattern = Pattern.compile("\\[[^\\]\\[]*\\]:\\s*(.*?)\\[\\w*:");
Matcher matcher = pattern.matcher(str);
while (matcher.find()){
    System.out.println(matcher.group(1)); 
} 
// => Some more sring here Model number 420 Family [Super-cool] [15b31013^^@#]