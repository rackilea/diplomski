boolean exit_from_three = false;
while (condition_one || exit_from_three) {
    exit_from_three = false;
    while (condition_two) {
        if (condition_three) {exit_from_three = true; break;}
        // do some stuff
    }
}