public static void deleteDuplicates(List<String> list)
{
    int pointer = 1;
    List<String> duplicates = new ArrayList<String>();
    for (int i = 0; i < list.size() - 1; i++) {
        if (list.get(i).equals(list.get(pointer))) {
            duplicates.add(list.get(i));

            if (pointer == 1) {
                duplicates.add(list.get(pointer));
            } else if ((pointer + 1) == list.size() - 1) {
                duplicates.add(list.get(pointer));
            }

            pointer++;
        } else if(duplicates.size() > 0) {
            display(duplicates);
            duplicates.clear();
            pointer++;
        }
    }
    if(duplicates.size() > 0){
        display(duplicates);
    }
}