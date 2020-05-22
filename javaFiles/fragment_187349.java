InputStream in = process.getInputStream();  // To read process standard output
InputStream err = process.getErrorStream(); // To read process error output

while (proc.isAlive()) {
    while (in.available() > 0 || err.available() > 0) {
        if (in.available() > 0)
            in.read(); // You might wanna echo it to your console to see progress

        if (err.available() > 0)
            err.read(); // You might wanna echo it to your console to see progress
    }

    Thread.sleep(1);
}