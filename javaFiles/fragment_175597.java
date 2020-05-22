@Override
public Token emit() {
    switch (getType()) {
    case UnterminatedStringLiteral:
        setType(StringLiteral);
        Token result = super.emit();
        // you'll need to define this method
        reportError(result, "Unterminated string literal");
        return result;
    default:
        return super.emit();
    }
}