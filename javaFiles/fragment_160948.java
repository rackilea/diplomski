function out = myfunc(str)
    out = cell(3,1);
    out{1} = sprintf('Welcome to %s!', str);
    out{2} = 99;
    out{3} = rand(10,1);
end