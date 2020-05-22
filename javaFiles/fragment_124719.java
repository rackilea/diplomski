Want to read 20 chars into                      at 0
Reader synchronized
Reader waiting.
Want to write abcdefghijklmnopqrst at 0 (20 chars)
Writer synchronized
Writing 8; now abcdefgh
Writer notifying buffer.
New writer lap
Continuing write
Want to write abcdefghijklmnopqrst at 8 (12 chars)
Writer synchronized
Writer waiting.
Reader resumed
Want to read 20 chars into                      at 0
Reader synchronized
Read 8 into abcdefgh            
Reader notifying buffer.
New read lap
Continuing read
Want to read 12 chars into abcdefgh             at 8
Reader synchronized
Reader waiting.
Writer resumed
Want to write abcdefghijklmnopqrst at 8 (12 chars)
Writer synchronized
Writing 8; now ijklmnop
Writer notifying buffer.
New writer lap
Continuing write
Want to write abcdefghijklmnopqrst at 16 (4 chars)
Writer synchronized
Writer waiting.
Reader resumed
Want to read 12 chars into abcdefgh             at 8
Reader synchronized
Read 8 into abcdefghijklmnop    
Reader notifying buffer.
New read lap
Continuing read
Want to read 4 chars into abcdefghijklmnop     at 16
Reader synchronized
Reader waiting.
Writer resumed
Want to write abcdefghijklmnopqrst at 16 (4 chars)
Writer synchronized
Writing 4; now qrstmnop
Writer notifying buffer.
Write finished.
Reader resumed
Want to read 4 chars into abcdefghijklmnop     at 16
Reader synchronized
Read 4 into abcdefghijklmnopqrst
Reader notifying buffer.
Read finsihed.
Read 20 chars
Read abcdefghijklmnopqrst