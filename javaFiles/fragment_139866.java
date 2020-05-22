testStreams :-
open('gnuprologstream.test',write,FileStream),
(
something(X),
write_term(FileStream,something(X),[]),
fail;
write(done)
),
close(FileStream).