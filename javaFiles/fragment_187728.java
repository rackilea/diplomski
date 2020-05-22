boolean doesExist = false;
int sum = 0;
for (IntWritable value : values) {
    int count = value.get();
    if (count < 0) {
        doesExist = true;
    } else {
        sum += count;
    }
}
if (doesExist) {
    context.write(key, new IntWritable(sum));
}