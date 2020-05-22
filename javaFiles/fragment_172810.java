public static String[] sortNames(String[] info) {

    String[] firstName = new String[info.length];
    String[] lastName = new String[info.length];

    for(int i = 0; i < info.length; i++) {
        String[] infos = info[i].split("\t");
        firstName[i] = infos[0];
        lastName[i] = infos[1];
    }

    return firstName;//also,you might need to change your return type to String[][] so that both array can be returned
}