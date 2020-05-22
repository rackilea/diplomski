@RELATION user

@ATTRIBUTE id   INTEGER  % this is actually useless
@ATTRIBUTE age  INTEGER
@ATTRIBUTE gender   {M,F}
@ATTRIBUTE occupation   {administrator,artist,doctor,educator,engineer,entertainment,executive,healthcare,homemaker,lawyer,librarian,marketing,none,other,programmer,retired,salesman,scientist,student,technician,writer}  % from u.occupation
@ATTRIBUTE zipcode  STRING

@DATA
1,24,M,technician,85711
2,53,F,other,94043
3,23,M,writer,32067
4,24,M,technician,43537
5,33,F,other,15213
6,42,M,executive,98101
7,57,M,administrator,91344
8,36,M,administrator,05201
...