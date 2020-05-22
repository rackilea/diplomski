interface Directive {
    public void execute(String line);
}

class LetDirective implements Directive {
    public void execute(String line) { ...handle LET directive here... }
}

...define other directives in the same way...