byte[] data = pcm.getData();
int n_bytes = pcm.getLen();
int n_samples = n_bytes / (n_channels*bytes_per_sample);
int k=0;
for (int i=0; i<n_samples; ++i) {
  for (int j=0; j<n_channels; ++j) {
    output[j][i] = data[k] + (data[k+1)<<8);
    k += 2;
  }
}