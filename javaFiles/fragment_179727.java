if (input.equals("<")) {
    try {
        String temp = url;
        url = back.pop();
        forward.push(temp); // this only executes if the last line completed unexceptionally
    } catch (EmptyStackException e) {
    }
}