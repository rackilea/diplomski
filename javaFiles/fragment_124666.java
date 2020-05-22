#!/usr/bin/perl
use strict; use warnings;

clean($_) for map glob($_), @ARGV;

sub clean {
    local @ARGV = @_;
    local $^I = ".bak";
    my $depth = 0;
    while (<>) {
        $depth ||= /^\s*for\b/ ? "0 but true" : 0;
        my $delta = ( ()= /\{/g ) - ( ()= /\}/g );
        $depth += $delta if $depth && $delta;
        $depth = 0 if $depth < 0;
        print unless $depth && /^\s*System\.out\.println/;
    }
    return !!1;
}