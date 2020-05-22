float sample_rate = 44100;
float samples_per_cycle = sample_rate / frequency;
int samples_to_produce = ....

for (int i = 0; i < samples_to_produce; ++i) {
   sample[i] = Math.floor(32767.0 * Math.sin(2 * Math.PI * i / samples_per_cycle));
}