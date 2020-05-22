if( m[
        \G
        (?:
            [^'"/]+
          | /(?![/*])
        )+
    ]xgc
) {
    my $code = substr( $_, $-[0], $+[0] - $-[0] );
    my $imported = 0;
    while( $code =~ /\b(import\s+)?\Q$package\E\b/g ) {
        if( $1 ) {
            ... # Found importing of package
            while( $code =~ /\b\Q$class\E\b/g ) {
                ... # Found mention of imported class
            }
            last;
        }
        ... # Found a package reference
    }
} elsif( m[ \G ' (?: [^'\\]+ | \\. )* ' ]xgc
    ||   m[ \G " (?: [^"\\]+ | \\. )* " ]xgc
) {
    # skip quoted strings
} elsif(  m[\G//.*]g­c  ) {
    # skip C++ comments