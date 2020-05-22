/** Java test suite **/

bare block {
    System.out.println(...); // 1 -- let stand
}

if (true) {
    for (foo in bar) {
        System.out.println; // 2 XXX
        if (x == y) {
            // plz kill this
            System.out.println // 3 XXX
        } // don't exit here
        System.out.println // 4 XXX
    }
}

for (...) {
    for {
        // will this be removed?
        System.out.println // 5 XXX
    }
}

/* pathological cases */

// intendation
for (...) { System.out.println()/* 6 */} 

// intendation 2
for (...)
{
    if (x)
    {
        System.out.println // 7 XXX
    }}

// inline weirdness
for (...) {
    // "confuse" script here
    foo = new baz() {void qux () {...}
    };
    System.out.println // 8 XXX
}