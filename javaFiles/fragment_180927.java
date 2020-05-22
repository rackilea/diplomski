T result = stream.filter(t -> {
    double x = getX(t);
    double y = getY(t);
    return (x == tx && y == ty);
}).findFirst().orElse(null);

return result;