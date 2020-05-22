if (multiple == 0.1) then {
    output = input
} else {
    if ((int) input * 10 % 2 == 1) {
        output -= 0.1
    } else {
        output = input
    }
}