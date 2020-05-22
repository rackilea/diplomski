final float inputLen = input.length;
final int resultLen = (int) Math.ceil(inputLen / n);
final int[] result = new int[resultLen];

for (int i = 0; i < inputLen; i++)
    result[i / n] += input[i];