SQL> l
  1  declare
  2  cur sys_refcursor;
  3  begin
  4  open cur for 'select sensorid, ' ||
  5  '    trunc(sampletime,''hh24'') +  ' ||
  6  '    (trunc(to_char(sampletime,''mi'')))/24/60 + ' ||
  7  '    (trunc(to_char(sampletime,''ss'')/:b1)*:b2)/24/60/60 as tspan,  ' ||
  8  '    avg(correctedvalue), ' ||
  9  '    max(qualityflag) ' ||
 10  'from scalarsample ' ||
 11  'where sampletime between DATE ''2010-10-27'' and DATE ''2010-10-28'' ' ||
 12  '    and sensorid = 4472 ' ||
 13  'group by sensorid,  ' ||
 14  '    trunc(sampletime,''hh24'') +  ' ||
 15  '    (trunc(to_char(sampletime,''mi'')))/24/60 + ' ||
 16  '    (trunc(to_char(sampletime,''ss'')/:b3)*:b4)/24/60/60 ' ||
 17  'order by tspan'
 18  using 15, 15, 15, 15;
 19  close cur;
 20* end;