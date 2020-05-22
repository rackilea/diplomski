%# Preparing a java.lang.String[] to play with.
a = javaArray('java.lang.String',10);
b = {'I','am','the','very','model','of','a','modern','major','general'};
for i=1:10; a(i) = java.lang.String(b{i}); end;

%# To cell array of strings. Simple, eh?
c = cell(a);

%# To char array. Also simple.
c = char(a);