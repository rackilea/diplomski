int display (int i, int j) {
    std::cout << i << " " << j << std::endl; 
    return i<j ? i:j; 
}
void my_funny_func (int a, int b, int c) {
    std::cout << a << " " << " " << b << " " c << std::endl;
}
...
   int i=1, j=1; 
   my_funny_func(display(i,j), display(++i, j), display(i, ++j));