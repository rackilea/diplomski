FastBitmap fb = new FastBitmap("c:\\files\\test.bmp");
fb.toGrayscale();
JOptionPane.showMessageDialog(null, fb.toIcon(), "Image", JOptionPane.PLAIN_MESSAGE); 

FourierTransform ft = new FourierTransform(fb);
ft.Forward();
fb = ft.toFastBitmap();
JOptionPane.showMessageDialog(null, fb.toIcon(), "Fourier Transform", JOptionPane.PLAIN_MESSAGE);

FrequencyFilter ff = new FrequencyFilter(0, 60);
ff.ApplyInPlace(ft);
fb = ft.toFastBitmap();
JOptionPane.showMessageDialog(null, fb.toIcon(), "Frequency Filter", JOptionPane.PLAIN_MESSAGE);

ft.Backward();
fb = ft.toFastBitmap();
JOptionPane.showMessageDialog(null, fb.toIcon(), "Result", JOptionPane.PLAIN_MESSAGE);