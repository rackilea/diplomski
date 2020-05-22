switch (generator.nextInt(2)) {
        case 0:
            return new Tree(x, y);
        case 1:
            return new Bush(x, y);
        default:                         // Requires default case
            return null;
    }