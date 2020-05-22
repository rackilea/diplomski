// DON'T DO THIS
for (MShape shape in shapes) {
    if (shape instanceof MRectangle) {
        renderer.renderRectangle(/*...*/);
    } else if (shape instanceof MEllipsis) {
        renderer.renderEllipse(/*...*/);
    }
    // etc.
}