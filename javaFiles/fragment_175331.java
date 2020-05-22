Complex[] fftData = FFT(myData);
int N = fftData.Length;

float T = 0.001;   
float f_c = 500;   //f_c = 500Hz
float f_s = 1/T;   //f_s = 1000Hz

float k = f_c/f_s;
int index = RoundToNextLargestInteger(k * N);

//Low pass filter   
for(int i = index; index < N; index++)
   fftData[i] = 0;