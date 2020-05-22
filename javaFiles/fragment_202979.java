while (<>) {
    $l{$1}++ if m/\s+from\s+(.+\.jar)/;
}

for $l (keys(%l)) {
    print "$l\n";
}