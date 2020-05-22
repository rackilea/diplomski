switch (readin.toLowerCase()) {
    case "n":
    case "no":
    case "false":
        return false;
    case "y":
    case "yes":
    case "true":
        return true;
    default:
        break;
}