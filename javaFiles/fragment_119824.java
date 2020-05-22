public static ArrayList<Student> remove(ArrayList<Student> array, Integer uid) {

    for (int i = 0; i < array.size(); i++) {
        array.get(i);
        if (i == uid) {
            array.remove(i);
            break;
        }
    }
    return array;

}