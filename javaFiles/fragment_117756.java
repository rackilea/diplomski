#!/usr/bin/perl -w
use strict;

open DATA, "java EchoServer | tail -f input.txt |"   or die "Couldn't execute program: $!";
while(my $line = <DATA>) {
  chomp($line);
  print "$line\n";
}
close DATA;