fs = 44100; % Hz
w = 1; % s

t = linspace(0, w, w*fs);
k = linspace(-fs/2, fs/2, w*fs);

% simulate the signal - time-dependent frequency
f = 10000*t; % Hz
x = cos(2*pi*f.*t);

m = 512; % SIZE
S = zeros(m, floor(w*fs/m));
for i = 0:(w*fs/m)-1
    s = x((i*m+1):((i+1)*m));
    S(:,i+1) = fftshift(fft(s));
end