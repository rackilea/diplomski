"^(\\[[^\\[\\]]*\\]){4}$"
 ││├─┘├───────┘│├─┘ │  └─ the end of the line.
 │││  │        ││   └─ repeat the capturing group four times.
 │││  │        │└─ a literal "]"
 │││  │        └─ the previous character class zero or more times.
 │││  └─ a character class containing anything but the literals "[" and "]"
 ││└─ a literal "[".
 │└─ start a capturing group.
 └─ the beginning of the string.