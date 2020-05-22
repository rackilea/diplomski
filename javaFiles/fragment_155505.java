public boolean check(int... values) {
    for (int value : values) 
        if(!Within(value, x, y)) return false;
    return true;
}

assert check(values);