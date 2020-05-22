# ================================================================================

# Turkish and Azeri

# I and i-dotless; I-dot and i are case pairs in Turkish and Azeri
# The following rules handle those cases.

0130; 0069; 0130; 0130; tr; # LATIN CAPITAL LETTER I WITH DOT ABOVE
0130; 0069; 0130; 0130; az; # LATIN CAPITAL LETTER I WITH DOT ABOVE

# When lowercasing, remove dot_above in the sequence I + dot_above, which will turn into i.
# This matches the behavior of the canonically equivalent I-dot_above

0307; ; 0307; 0307; tr After_I; # COMBINING DOT ABOVE
0307; ; 0307; 0307; az After_I; # COMBINING DOT ABOVE