int maxThreads = 2;
int maxValuePerThread = 1000 / maxThreads;
int start = 0;
int end = maxValuePerThread;
double resultOut = 0d;
PiCalculator pc = new PiCalculator();
for(int i = 0; i < 2; i++) {
    Pi p = pc.new Pi(start, end);
    p.run();
    start = start + end;
    end = end + maxValuePerThread;
    resultOut += p.getResult();
}