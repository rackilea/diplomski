Fs = 44100;                // sample rate, e.g. 44.1 kHz
overlap = 0.5;             // overlap = 50%
nw = Fs * 0.025;           // no of samples in window
ns = nw * (1.0 - overlap); // no of samples to increment n0, n1
n0 = 0;                    // window sample no begin
n1 = n0 + nw;              // window sample no end
N = 10 * Fs;               // N = total no of samples to process, e.g. 10 seconds

do
    get nw samples from n0 to (n1 - 1) into temporary buffer
    apply window function to temporary buffer
    apply FFT to temporary buffer
    ... etc ...
    n0 += ns; // increment window start/end by no of overlap samples
    n1 += ns;
while n1 <= N;