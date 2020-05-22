// check if word exists in database and add if it not.
int i = 0;
for(String word : explode) {
    if(common.get(word) == null) {
        if(word.equals(trigger)) {
            ary = new ArrayList<String>(explode);
        }

    ...
    i++;
}