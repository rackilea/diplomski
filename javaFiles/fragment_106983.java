use Digest::SHA1;
use Encode;
my $mystring ="zWh9YZX3";  
my $bytes = encode('???', $mystring);
my $sha1 = Digest::SHA1->new;
$sha1->add($bytes);
print $sha1->digest;