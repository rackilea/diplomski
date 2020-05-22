// Softmax transfer function for output layer.
sum = 0;
for (int j = 0; j < 4; ++j) {
    out[j] = logistic(out[j]);
    sum += out[j];
}
for (int j = 0; j < 4; ++j) {
    out[j] = out[j] / sum;
}