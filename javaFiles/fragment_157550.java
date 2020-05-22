public static String formatMyList(List list){
        String str = list.toString().replace("[", "I GOT ");
        str = str.replace("]", "!");
        str = str.replace(",", " AND");
        return str;
    }