Error = X * theta - y;
for i = 1:2
    S(i) = sum(Error.*X(:,i));
end

theta = theta - alpha * (1/m) * S'