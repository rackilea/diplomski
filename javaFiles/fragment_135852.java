method(input) {
    typed_input = '';
    for (word in input) {
        if (word is noun) {
            typed_input += 'n'
        else if (word is adjective)
            typed_input += 'a'
        else if (word is hyphen)
            typed_input += 'h'
        else if (word is verb Past Participle)
            typed_input += 'v'
        else if (word is verb Present Participle)
            typed_input += 'p'
        else if (word is one of the special adjectives)
            typed_input += 's'
        else
           throw exception("invalid input")
    }
    return typed_input.match("a*n+h[v|p|s]a*n+")
}