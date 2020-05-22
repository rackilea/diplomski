for (int i = 0; i < cores; i++)
{
    final int index = i; // put value of "i" into a final variable
    threads[i] = new Thread(new Runnable() {
        public void run() {
            // use "index" instead of "i"
            for (int j = index * (n / cores); j < (index + 1) * N / P; j++) {
                double x = (j + 0.5) * step;
                sum += 4.0 / (1.0 + x * x);
            }
        }
    });
}