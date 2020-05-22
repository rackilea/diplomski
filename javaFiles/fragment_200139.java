append = false;

for (...) {
    ...

    if (append) {
        sb.append('_');
    }

    ...

    append = true;
}