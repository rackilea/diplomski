syms x

n = str2double(input('Enter an integer: ','s'));
while isnan(n) || fix(n) ~= n
  disp('Please enter an integer')
  n = str2double(input('Enter an integer: ','s'));
end


f = sym(input('Enter a function(String): ','s'));

fprintf('f(x) = %s\n', char(f));

derivatives = sym('A', [1 n]);
for ii=1:n
    derivatives(ii) = diff(f,ii);
    fprintf('f^{(%i)}(x) = %s\n', ii, char(derivatives(ii)));
end