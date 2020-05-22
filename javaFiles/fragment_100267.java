% open the file
fid = fopen(fileName); 
% load each line as a single string
tmp = textscan(fid, '%s', 'delimiter', '\n'); 
% textscan wraps its results in a cell, remove that wrapping
rawText = tmp{1}; 
nLines = numel(rawText);

%create a cell array to store the processed string
data = cell(nLines, 1);
for i = 1:nLines
  %scan a line of text returning a vector of doubles
  tmp = textscan(rawText{i}, '%f');
  data{i} = tmp{1}; 
end