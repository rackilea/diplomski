Connection c = null;
try {
    c = configuration.connectionProvider().acquire();
    someOtherCode(c, ...);
}
finally {
    configuration.connectionProvider().release(c);
}