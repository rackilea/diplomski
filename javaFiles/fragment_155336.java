# Two helper procedures that know how to do the framing encoding/decoding
proc writeJavaUTF {sock msg} {
  set data [encoding convertto utf-8 $msg]
  puts -nonewline $sock [binary format "S" [string length $data]]$data
}
proc readJavaUTF {sock} {
  binary scan [read $sock 2] "S" len
  set data [read $sock [expr {$len & 0xFFFF}]]
  return [encoding convertfrom utf-8 $data]
}

# This is your sample code, stripped of comments and adapted
set svcPort 9999
proc doService {sock msg} {
  writeJavaUTF $sock "$msg"; # <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
}
proc svcHandler {sock} {
  set l [readJavaUTF $sock]; # <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
  puts "The packet from the client is $l"
  if {[eof $sock]} {
     close $sock
  } else {
    doService $sock $l
  }
}
proc accept {sock addr port} {
  fileevent $sock readable [list svcHandler $sock]
  # Next *three* lines are changed!
  fconfigure $sock -buffering line -blocking 0 -translation binary
  writeJavaUTF $sock "$addr:$port, You are connected to the echo server."
  writeJavaUTF $sock "It is now [exec date]"
  puts "Accepted connection from $addr at [exec date]"
}
socket -server accept $svcPort
vwait events