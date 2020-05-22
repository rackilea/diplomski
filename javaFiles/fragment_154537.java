// with Java 7: in automatically closed
try (InputStream in = ...;) {
    // do stuff
} catch (WhateverException e) {
    // handle exception
}

// with Java 6
InputStream in = ...;
try {
    // do stuff
} catch (WhateverException e) {
    // handle exception
} finally {
    in.close();
}