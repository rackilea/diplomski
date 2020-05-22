schiffe_loop:
for(int i = 0; i < schiffe.length-1; i++){
    some_stuff();
    for(int k = 0; k < stationen.length-1; k++){
        if (something_really_bad_happened()) {
            break schiffe_loop;
        }
    }
}