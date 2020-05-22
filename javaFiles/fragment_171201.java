class This
{
    double b;
    int e;
    double val;

    This(double base, int exp)
    {
        b = base;
        e = exp;
        val = 1;

        if (exp == 0)
        {
            return;
        }
        for (int i = exp; i > 0; i--)
        {
            val*=base;
        }

    }

    double get_pwr()
    {
        return val;
    }
}