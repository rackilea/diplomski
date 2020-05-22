use strict;
use warnings;
use Digest::SHA1 qw( sha1_hex );

my $bytes = "zWh9YZX3";
my $digest_hex = sha1_hex($bytes);

print("INSERT INTO Foo VALUES (UNHEX('$digest_hex'))\n");