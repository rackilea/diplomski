private String replaceName(String content, String fileName, char ch) {
    if (countMatches(content, getName(oldName, ch)) > 0)
        content = replaceName(count, getName(oldName, ch), fileName, getName(newName, ch), content);

    return content;
}

Files.walk(path)
     .filter(this::shouldChange)
     .forEach(p -> {
         try {
             String fileName = p.getFileName().toString();
             final String content = new String(Files.readAllBytes(p), StandardCharsets.UTF_8);
             String changedContent = replaceName(content, fileName, '1');
             changedContent = replaceName(content, fileName, '2');

             if (!content.equals(changedContent))
                 Files.write(p, content.getBytes(StandardCharsets.UTF_8));
         } catch(IOException e) {
             e.printStackTrace();
         }
     });
}