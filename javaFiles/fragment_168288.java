#!/usr/bin/perl
use MIME::Base64;
use DBI;

my $dbh = DBI->connect( "dbi:Pg:dbname=depesz;port=5840", "depesz" );
my $blob = "\x84";
my $encoded = encode_base64( $blob );
$dbh->do("INSERT INTO q (x) VALUES (decode(?, 'base64'))", undef, $encoded );