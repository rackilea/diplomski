function evalWithLabel(js, label) {
    try {
        return eval(js);
    } catch(err) {
        throw label + ': ' + err;
    }
}