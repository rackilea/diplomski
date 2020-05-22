switch (type) {
    case WHITESPACE:
    case RETURN:
        break;
    case NUMBER:
        print("got number: " + value);
        break;
    default:
        print("syntax error");
}