// 1
try { 
    if (myObject.getClass().getDeclaredMethod("myMethod").invoke(myObject) == null) {
    }
} catch (Exception e) {
}

// 2
try { 
    if (myObject.getClass().getDeclaredMethod("myMethod", Type1.class, Type2.class).invoke(myObject, arg0, arg1) == null) {
    }
} catch (Exception e) {
}