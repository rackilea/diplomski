boolean in13 = false;

//... other lines...


if (line.equals("[13]")) {
    in13 = true;
} else if (line.startsWith("[")) {
    in13 = false;   //another block started, clear flag
}

if (in13 && line.startsWith("key5=")) {
    // you've found it
}