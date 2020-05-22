if (m % 2 == 0) {
        result = m_pow(n, m / 2);
        System.out.println("m = " + m + ", result = " + result + ", returning " + ((result * result) % mod));
        return ((result * result) % mod);
    } else {
        result = m_pow(n, (m - 1) / 2);
        System.out.println("m = " + m + ", n % mod = " + (n % mod) + ", result = " + result + ", returning " + (((n % mod) * (result * result)) % mod));
        return (((n % mod) * (result * result)) % mod);
    }