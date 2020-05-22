>> j = java.util.LinkedList;
>> for idx = 1:1e5, j.add(single(idx)); end
>> tic, out = Helper.toFloatArray(j); toc
Elapsed time is 0.006553 seconds.
>> tic, cell2mat(cell(j.toArray)); toc
Elapsed time is 0.305973 seconds.