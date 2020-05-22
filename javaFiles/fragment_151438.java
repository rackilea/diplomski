// prevAverage * (prevCount/curCount) + curImg/curCount
        for (int i = 0; i < average.size(); i++) {
            Core.multiply(average.get(i), new Scalar((count - 1) / ((double) count)), average.get(i));
            Mat temp = new Mat();
            // Core.divide(count, splitImg.get(i), temp);
            Core.multiply(splitImg.get(i), new Scalar(1.0 / count), temp);
            Core.add(average.get(i), temp, average.get(i));
        }