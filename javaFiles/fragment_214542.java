long a = 12, d = 34;
double ratio = a / (double) d;
DecimalFormat ratioFormat = new DecimalFormat("#.##");
DecimalFormat percentFormat= new DecimalFormat("#.#%");
System.out.println("ratio = " + ratioFormat.format(ratio));
System.out.println("percent = " + percentFormat.format(ratio));