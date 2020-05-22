public static void removeDuplicates(ArrayList<String> list) {
    for(int i = 0; i < list.size(); i++) {
        String s = list.get(i);
        for(int j = 0; j < list.size() - 1; j++) {
            String s2 = list.get(j);
            if(s2.equals(s))
                ; // <-- conditional
            {     // <-- unconditional
                list.remove(j + 1);
            }
        }
    }
}