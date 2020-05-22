@Override
public long skip(long n) throws IOException {
    // make sure not to skip fractional frames
    final long reminder = n % frameSize;
    if (reminder != 0) {
        n -= reminder;
    }
    if (n <= 0) {
        return 0;
    }

    if (frameLength != AudioSystem.NOT_SPECIFIED) {
        // don't skip more than our set length in frames.
        if ((n / frameSize) > (frameLength - framePos)) {
            n = (frameLength - framePos) * frameSize;
        }
    }
    long remaining = n;
    while (remaining > 0) {
        // Some input streams like FileInputStream can return more bytes,
        // when EOF is reached.
        long ret = Math.min(stream.skip(remaining), remaining);
        if (ret == 0) {
            // EOF or not? we need to check.
            if (stream.read() == -1) {
                break;
            }
            ret = 1;
        } else if (ret < 0) {
            // the skip should not return negative value, but check it also
            break;
        }
        remaining -= ret;
    }
    final long temp =  n - remaining;

    // if no error, update our position.
    if (temp % frameSize != 0) {
        // Throw an IOException if we've skipped a fractional number of frames
        throw new IOException("Could not skip an integer number of frames.");
    }
    framePos += temp/frameSize;
    return temp;
}