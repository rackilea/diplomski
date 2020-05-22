abstract class Color<T extends ColorThings> {
    protected T[] things;
}

class RedColor extends Color<RedThings> {
}

// And so on.