static unsigned id = 0;
long long fib(int n)
{
    auto call_id = id++;
    std::cout << "fib" << call_id << " [label=\"fib(" << n << ")\"]\n";
    if (n <= 1) return 1;
    std::cout << "fib" << call_id << " -> fib" << id << '\n';
    auto fib_n_minus_2 = fib(n-2);
    std::cout << "fib" << call_id << " -> fib" << id << '\n';
    auto fib_n_minus_1 = fib(n-1);
    return fib_n_minus_2 + fib_n_minus_1;
}

int main()
{
    std::cout << "digraph {\n";
    fib(5);
    std::cout << "}\n";
}