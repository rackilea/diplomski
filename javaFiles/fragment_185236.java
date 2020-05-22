public static Integer addOne(Integer in) {
    in = in + 1;
    return in;
}

// ... sometime later
Integer three = Integer.valueOf(3);
Integer four = addOne(three);