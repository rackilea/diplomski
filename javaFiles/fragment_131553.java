public static int round(int original) {
    if original % 10 <= 2 {
        return original - (original % 10)
    } else if original % 10 <= 7 {
        return original - (original % 10) + 5
    }
    return original - (original % 10) + 10
}