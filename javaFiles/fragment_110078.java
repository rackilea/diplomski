#!/usr/bin/perl
use 5.10.1;
use strict;
use warnings;

my $str = q!ABC/DEF_abc.def_PQR/STU_ghi_jkl.mno_a_b_c.z_a_b_c_d.z_a_b_c_d_e.z!;
my $re = qr!((?:[^_./]+/[^_./]+)|(?:[^_./]+\.[^_./]+)|(?:[^_./]+(?:_[^_./]+)+\.[^_./]+))!;
while($str=~/$re/g) {
    say $1;
}