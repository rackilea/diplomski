public static void main(String[] args) {
    List<String> list = new ArrayList<String>();

    list.add("Luke Skywalker has returned");
    list.add("to his home planet of Tatooine");
    list.add("in order to — okay, you");
    list.add("know what, we don't care.");
    list.add("We were thinking of not even");
    list.add("doing this one.");

    int largestLineLength = 0;

    for (String s : list) {
        int length = s.length();
        if (length > largestLineLength) {
            largestLineLength = length;
        }
    }

    List<String> outputs = new ArrayList<String>();

    for (String s : list.subList(0, list.size() - 1)) {

        int needSpace = largestLineLength - s.length();
        if (needSpace > 0) { //check if we need space in this line.
            String[] words = s.split(" "); //find words in the line
            int index = 0;

            StringBuilder[] stringBuilders = new StringBuilder[words.length];

            for (int i = 0; i < words.length - 1; i++) {
                stringBuilders[i] = new StringBuilder(words[i]);
                stringBuilders[i].append(" ");
            }

            stringBuilders[words.length - 1] = new StringBuilder(words[words.length - 1]);

            while (needSpace > 0) { //add spaces and decrease needSpace until it reaches zero.
                stringBuilders[index].append(" "); //add space to the end of every world in order
                index = index == words.length - 2 ? 0 : index + 1; //words-2 is because we didnt want any spaces after last word of line.
                needSpace--;
            }

            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < words.length; i++) {
                stringBuilder.append(stringBuilders[i]);
            }


            s = stringBuilder.toString();
        }
        outputs.add(s);
    }
    outputs.add(list.get(list.size()-1));

    for(String s : outputs){
        System.out.println(s);
    }
}