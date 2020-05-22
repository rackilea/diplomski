import reactor.core.Exceptions;

...

try {
    return myService.getObject(.....).block();
} catch (Exception e) {
    throw Exceptions.unwrap(e);
}