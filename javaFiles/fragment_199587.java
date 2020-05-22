┌─ [ ] lowercase      { } 3 to 9 times  ─┐
           │                                        │
           │        ┌─ \x20 spacebar                │
         ┌─┴─┐     ┌┴─┐                           ┌─┴─┐
^(?:[A-Z][a-z]{3,9}\x20){1,2}[A-Z]\.\x20[A-Z][a-z]{3,9}$
│   └─┬─┘              │           │                   │
│     │                │           └─ \. period        │
│     │                │                               │
│     │                └─ (?: ) grouping               │
│     │                                                │
│     └─ [ ] uppercase letter        $ end of string ──┘
│
└─ ^ beginning of the string