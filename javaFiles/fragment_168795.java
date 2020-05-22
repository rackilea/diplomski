%# convert string and write as bytes
str = 'Some stuff.';
b = unicode2native(str,'UTF-16');
fid = fopen('utf16.txt','wb');
fwrite(fid, b, '*uint8');
fclose(fid);