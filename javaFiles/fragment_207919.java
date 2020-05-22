public static double[] smooth(double[] signal)
    {
        int[] = result = new int[signal.length - 1];
        result[0] = (signal[0] + signal[1]) / 2;
        for(int i = 1; i < signal.length - 1; i++)
        {
            result[i] = (signal[i - 1] + signal[i] + signal[i + 1]) / 3;
        }
        result[signal.length - 1] = (signal[signal.length - 2] + signal[signal.length - 1]) / 2;
        return result;
    }