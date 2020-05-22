func biggestPrime(n uint64) uint64 {
    p, i := uint64(1), uint64(0)
    for i = 2; i < uint64(math.Sqrt(float64(n))) + uint64(1); i++ {
        for n % i == 0 {
            n /= i
            p = i
        }
    }
    if n > 1 {
        p = n
    }
    return p
}