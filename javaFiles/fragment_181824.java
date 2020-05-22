#!/usr/bin/perl
use utf8;
use open qw(:utf8 :std);
use Unicode::Collate::Locale;

my $Collator = Unicode::Collate::Locale->new(
    locale        => "de__phonebook",
    level         => 1,
    normalization => undef,
);

my $full = "Ich müß Perl studieren.";
my $sub  = "MUESS";
if (my ($pos,$len) = $Collator->index($full, $sub)) {
    my $match = substr($full, $pos, $len);
    print "Found match of literal ‹$sub› at position $pos in ‹$full› as ‹$match›\n";
}