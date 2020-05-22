T[] arr2 = Arrays.copyOf(packDistance,packDistance.length);
for(int i = 0; i < 2; i++){
            double psd = JMath.sqrt((((4*cc)/(JMath.pow((1 + 6*frequency[i]*cc), (double) 5/3)))*df));              
            double cohC = H*JMath.sqrt((frequency[i]/A.averageHubWindSpeed)*(frequency[i]/A.averageHubWindSpeed) + (.12/Lc)*(.12/Lc));          
            BLAS.getInstance().sscal(packDistance.length, (float) cohC,packDistance, 1);    
}