List<String> list = new ArrayList<>();

for (String word : pattern) {
    if (word.length() < 3 || word.equals("with")) {
        continue;
    }

    list.add(word);
}

list.toArray(new String[list.size()]);