if (index == array.length / 2)  // i.e. 1 position past the middle
    return

out[index] = in[in.length - index - 1];
out[in.length - index - 1] = in[index];

reverse(in, out, index+1);