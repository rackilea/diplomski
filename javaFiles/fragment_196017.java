public String cartesian (Set other)
{
    String [] cart = new String [this.size * other.size];

    int k = 0;
    for (int i : this.data)
    {
        for (int j : other.data)
        {
            cart[k++] = "(" + i + "," + j + ")";
        }
    }

    return Arrays.toString(cart);   
}