use threads;
my $thr = threads->create(\&sub1); # Spawn the thread
$thr->detach(); # Now we officially don't care any more
sleep(15); # Let thread run for awhile
sub sub1 {
$a = 0;
while (1) {
$a++;
print("\$a is $a\n");
sleep(1);
}
}