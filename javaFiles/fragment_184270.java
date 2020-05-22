package Temp;

sub new {
    my $self = bless {
        'my_int' => 0,
        'my_array' => [] # The trick here is to use an array *reference*
                         # hence the square brackets rather than ()
    };
    return $self;
}