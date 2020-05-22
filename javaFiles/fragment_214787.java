try {
    f();
    d();
} catch (Ex1 ex) {
    println("main caught Ex1");
} catch (Ex3 ex) {
    println("main caught Ex3");
} finally {
    println("main finally");
}