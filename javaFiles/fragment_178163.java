function &return_by_reference() {
    $something = make_something();
    return $something;
}

function increment(&$n) {
    // This changes $n because it is a reference parameter
    $n++;
}