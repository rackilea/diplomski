// true
console.log(
    "FOOBAR-FOOBAR-" == "foobar-FooBar-".replace(
        /(([fF][oO]{2})[bB]ar)/g,
        function(  all, capture1, capture2 ) {
            return all.toUpperCase();
        }
    )
);

// true
console.log(
    "FOO-FOO-" == "foobar-FooBar-".replace(
        /(([fF][oO]{2})[bB]ar)/g,
        function( all, capture1, capture2 ) {
            return capture2.toUpperCase();
        }
    )
);