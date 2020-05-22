ArrayList<double[]> okna = new ArrayList<>();
            ArrayList<freqTime> lista = new ArrayList<freqTime>();

            int po2 = (int) Math.pow(2,
                    Integer.parseInt((String) potega2Input.getText()));

            po2 /= 2;
            double[] triangles = new double[po2];
            double maxWykres = 0;
            int licznik = 0;
            int licznik2 = 0;
            int T = frames.length;

            boolean wykresFlaga = false;

            for (int k = 0; k < T; k += po2) {

                licznik = 0;
                licznik2 = 0;
                double[] tmp = new double[po2];

                Complex[] zespolone = new Complex[po2];

                for (int i = k; i < k + po2; i++) {

                    if (i < T) {
                        tmp[licznik] = frames[i];
                        zespolone[licznik] = new Complex(frames[i], 0);
                        licznik2 = licznik;
                    } else {
                        tmp[licznik] = frames[licznik2];
                        zespolone[licznik] = zespolone[licznik2];

                    }
                    licznik++;
                }

                okna.add(tmp);

                FFT fft = new FFT();

                zespolone = fft.fft(zespolone);

                double maxF = 0;
                double maxFI = 0;

                double maxH = findMaxComp(zespolone);
                double[] doWykresu = new double[zespolone.length];
                for (int a = 2; a < 100; a++) {

                    for (int i = 0; i < po2; i++) {
                        doWykresu[i] = zespolone[i].abs();
                        triangles[i] =  Math.abs(i % (2 * a) - a)
                                * (maxH) / a;

                        // triangles[i] = Math.abs(i % (2 * a) - a) * (maxH)
                        // / a;

                    }

                    double sumT = 0;
                    for (int i = 0; i < po2 / 2; i++) {

                        sumT += triangles[i] * doWykresu[i];
                    }

                    if (sumT > maxF) {
                        maxF = sumT;
                        maxFI = a;
                    }

                }
                //
                // maxFI /= 2;
                //
                if (wykresFlaga == false) {
                    maxWykres = maxH;
                }
                for (int i = 0; i < po2; i++) {
                    doWykresu[i] = zespolone[i].abs();
                    triangles[i] =  Math.abs(i % (2 * maxFI) - maxFI)
                            * (maxWykres) / maxFI;

                }
                if (wykresFlaga == false) {
                    System.out.println("Max w widmie: " + maxWykres);
                    new Wykres(doWykresu, 1, triangles);
                    wykresFlaga = true;
                }
                // System.out.println((2 * 44100 / po2) * maxFI);
                System.out.println((float) (44100 / (float) po2)
                        * 2*(float) maxFI + " Znalzione a: " + maxFI);

                lista.add(new freqTime(
                        (int) ((float) (44100 / (float) po2) *2* (float) maxFI),
                        (double) ((double) po2 / 44100)));

                /*
                 * System.out.println((44100 / po2) * maxFI + " " + maxFI +
                 * " " + maxFI / 44100 + " " + 44100 / (maxFI / po2 * 44100)
                 * + " " + 44100 * maxFI / T);
                 */
                // System.out.println(zespolone[(int) maxFI/2].abs());
            }