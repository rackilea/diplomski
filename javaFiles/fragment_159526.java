use 5.010;
use strict;

use utf8;

my $rx0 = qr/[+-]?(?:\d+(?:\.\d*)?|\.\d+)/;

my $rx1 = qr{
    [+-] ?
    (?: \d+
        (?: \. \d* ) ?
      |
        \. \d+
    )
}x;

my $rx2 = qr{
    (?: [+-]                (?{ say "\tleading sign"                })
    ) ?
    (?: \d+                 (?{ say "\tinteger part"                })
        (?: \.              (?{ say "\tinternal decimal point"      })
            \d*             (?{ say "\toptional fractional part"    })
        ) ?
      |
        \.                  (?{ say "\tleading decimal point"       })
        \d+                 (?{ say "\trequired fractional part"    })
    )                       (?{ say "\tsuccess"                     })
}x;

my $string = <<'END_OF_STRING';

    The Earth’s temperature varies between
    -89.2°C and 57.8°C, with a mean of 14°C.

    There are .25 quarts in 1 gallon.

    +10°F is -12.2°C.

END_OF_STRING

while ($string =~ /$rx2/gp) {
    printf "Number: ${^MATCH}\n";
}