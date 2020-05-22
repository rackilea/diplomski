long long fib(int n)
{
    if (n <= 1) return 1;
    std::cout << "fib" << n << " -> fib" << n-2 << '\n';
    std::cout << "fib" << n << " -> fib" << n-1 << '\n';
    return fib(n-2) + fib(n-1);
}

int main()
{
    std::cout << "digraph {\n";
    fib(5);
    std::cout << "}\n";
}