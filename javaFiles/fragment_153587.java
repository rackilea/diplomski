for(Andmed currentAndmed : andmed) {

                double[] andmed1 = {currentAndmed.getTemp0(), currentAndmed.getTemp6(), currentAndmed.getTemp12(), currentAndmed.getTemp18(), currentAndmed.getTemp24()};
                double[] andmedFaili = {currentAndmed.getKuupaev(), KronKesk2(andmed1)};
                bw.write(Arrays.toString(andmedFaili) + "\n");
            }