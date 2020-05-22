public static String shap(String i, int numberinput) {
    //error check, not working for even numbers
    if(numberinput%2 == 0)
        return null;

    //terminating condition, stop recursion when this occurs.
    if(numberinput == 1)
        return "X";

    //recursion, call recursive until terminating condition occurs.
    return "X" + i + shap(i, numberinput-2) + i + "X";
}