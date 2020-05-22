/**
 * @throws This won't appear if you don't write `throws` and this might
 * mislead the programmer.
 */
public void func(int a) throws IllegalArgumentException {
    if(a < 0) 
        throw new IllegalArgumentException("a should be greater than 0.");
}