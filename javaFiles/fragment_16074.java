public Object method()
{
    Object objects[] = { a, b, c, d }; // Assuming objects a, b, c and d exist...

    boolean condition1;
    boolean condition2;

    /* 
     * Truth Table
     * 
     *    condtion1  condition2   Object
     *      false      false        d
     *      false      true         c
     *      true       false        b
     *      true       true         a 
     */

    int selector = (condition1 ? 0 : 1) + (condition2 ? 0 : 2);

    return objects[selector];
}