public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
            // get number of threads to be run
            Scanner in = new Scanner(System.in);
            int numberOfThreads = in.nextInt();

            // read file
            File file = new File("testfile.txt");
            long fileSize = file.length();
            long chunkSize = fileSize / numberOfThreads;

            FileInputStream input = new FileInputStream(file);

            ExecutorService pool = Executors.newFixedThreadPool(numberOfThreads);
            Set<Future<int[]>> set = new HashSet<Future<int[]>>();

            while (input.available() > 0) {
               //create buffer for every thread.
                byte[] buffer = new byte[(int) chunkSize];

                if (input.available() < chunkSize) {
                    chunkSize = input.available();
                }

                input.read(buffer, 0, (int) chunkSize);

                Callable<int[]> callable = new FrequenciesCounter(buffer);
                Future<int[]> future = pool.submit(callable);
                set.add(future);
            }

            // let`s assume we will use extended ASCII characters only
            int alphabet = 256;

            // hold how many times each character is contained in the input file
            int[] frequencies = new int[alphabet];

            // sum the frequencies from each thread
            for (Future<int[]> future : set) {
                for (int i = 0; i < alphabet; i++) {
                    frequencies[i] += future.get()[i];
                }
            }

            input.close();

            for (int i = 0; i < frequencies.length; i++) {
                if (frequencies[i] > 0)
                    System.out.println((char) i + "  " + frequencies[i]);
            }
        }

    }