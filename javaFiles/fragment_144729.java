switch (tokensLeft) {
    case 3:
        rawListener.binaryInfo(
                tokens.nextToken(),
                parseInt(tokens.nextToken()),
                tokens.nextToken(),
                this);
        break;
    case 2:
        rawListener.binaryInfo(
                tokens.nextToken(),
                parseInt(tokens.nextToken()),
                this);
        break;
    default:
        throw new IllegalArgumentException("Method call binaryInfo could not be done because: \"Wrong number of parameters\"");
}