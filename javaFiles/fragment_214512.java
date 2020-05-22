PS Home:\> [regex]::Matches('hello, dflk 1234 12345678, wod-=0, 87654321', '(?<=^|\s|\d{8})(?!\d{8})\S+(?=$|\s|\d{8})')|
select -exp Value
hello,
dflk
1234
,
wod-=0,