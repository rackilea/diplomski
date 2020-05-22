#!/usr/bin/perl

use strict;
use warnings;

use Win32;
use Win32::API;
use Win32::IPHelper;
use Win32::Process::Info qw( NT );

use Data::Dumper;

my @tcptable;

Win32::IPHelper::GetExtendedTcpTable(\@tcptable, 1);

my $pi = Win32::Process::Info->new;
my %pinfo = map {$_->{ProcessId} => $_ } $pi->GetProcInfo;

for my $conn ( @tcptable ) {
    my $pid = $conn->{ProcessId};
    $conn->{ProcessName} = $pinfo{$pid}->{Name};
    $conn->{ProcessExecutablePath} = $pinfo{$pid}->{ExecutablePath};
}

@tcptable =
    sort { $a->[0] cmp $b->[0] }
    map  {[ sprintf("%s:%s", $_->{LocalAddr}, $_->{LocalPort}) => $_ ]}
    @tcptable;

print Dumper \@tcptable;