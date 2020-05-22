filename = 'myfile.svg';
XMLdata = fileread(filename);

new_claim = strrep(XMLdata, 'Sans', 'Times New Roman');

fid = fopen(filename, 'w+');
fwrite(fid, new_claim);
fclose(fid);