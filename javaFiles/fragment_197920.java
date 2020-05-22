use IPC::Open2;

my $pid = open2( \*from_jar, \*to_jar, $command )
            or die "Could not open 2-way pipe: $!";

print to_jar, "Here is input\n";  # Pass in data

my $result = <from_jar>;          # Retrieve results