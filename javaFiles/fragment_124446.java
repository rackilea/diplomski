Style notes

===========

[...]

There are several occurrences of the unusual "do {} while
(!cas...)"  which is the simplest way to force an update of a
CAS'ed variable. There are also other coding oddities (including
several unnecessary-looking hoisted null checks) that help
some methods perform reasonably even when interpreted (not
compiled).