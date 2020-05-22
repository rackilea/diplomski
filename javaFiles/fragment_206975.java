@Override
public synchronized void onDraw(final Canvas canvas) {

    int n = 35;
    int j = 1;

    canvas.drawRect(0, 0, getWidth(), getHeight(), paint);

    if (i != 0) {

        for (j = 1; j <= i; j++) {

            if (n > getWidth() - 25) {
                n = 36;
                k = n;
                //drawPulseIterator=k;
            } else {

                n += 1;

            }

            canvas.drawRect(k++, 0, n + 5, getHeight(), paint);
            canvas.drawLine(n, (getHeight() / 2) - a[j], n + 1, (getHeight() / 2) - a[j - 1], paint1);
        }
    }

    i++;
    if (j == a.length) {
        i = 0;
    }

    invalidate();

}