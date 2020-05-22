syms x

f = exp(-(x/2));                     % function
n = 5;                               % number of derivatives

derivatives = sym('A', [1 n]);       % allocate memory

for ii=1:n
    derivatives(ii) = diff(f,ii);
end