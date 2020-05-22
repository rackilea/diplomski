switch(this) {
    case RED:
        return "Red";
    case GREEN:
        return "Green";
    case BLUE:
        return "Blue";
    default:
        throw new IllegalStateException("Unexpected enum value: " + this.name());
}