boolean oneTime = false;
while (...) {
    ...
    if (<some test for printing>) {
        if (!oneTime) {
            oneTime = true;
            <print your message>
        }
    }
    ...
    if (<some other test for printing>) {
        if (!oneTime) {
            oneTime = true;
            <print your message>
        }
    }
    ...
}