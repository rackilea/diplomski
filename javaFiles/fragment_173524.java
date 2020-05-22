my $a = "123";
if($a =~ /(?=.*5.*)(?=.*3.*)(?=.*1.*)|(?=.*2.*)(?=.*7.*)(?=.*9.*)/)
{
        print "$a matches";
}
else
{
        print "$a does not match";
}