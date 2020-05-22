use utf8;
use DateTime::Format::CLDR ();

my $cldr = DateTime::Format::CLDR->new(
    locale   => 'zh_CN',
    pattern  => 'yyyy/MM/dd a HH:mm:ss',
    on_error => 'croak',
);

$cldr->parse_datetime('2009/11/26 下午 04:40:54'); # returns a DateTime object