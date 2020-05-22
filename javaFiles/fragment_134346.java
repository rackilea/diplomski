$ cat change
a.b.c = 30
d.e.f = 50

$ awk -F' *= *' 'NR==FNR{a[$1]=$0;next} ($1 in a){$0=a[$1]; delete a[$1];}1; END{for (i in a) print a[i]}' change orig.conf
a.b.c = 30
p.q.r = 30
d.e.f = 50