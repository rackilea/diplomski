function main$lambda(s1, s2) {
    println(s1 + s2);
    return Unit;
}

function main(args) {
    var f = main$lambda;
    /* ... */
}