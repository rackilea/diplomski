use Data::Dumper;

my $var = "(42, 10) d (23, 1) (123, 4) (32, 10) d (12, 9)";

$var =~ s/\)/,/g;
$var =~ s/\(//g;
$var =~ s/d/d,/g;
$var =~ s/\s*//g;
my @arr = split /,/, $var;
print Dumper \@arr;