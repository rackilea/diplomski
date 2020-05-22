public class USCrimeClass { 
    public static void main(String[] args) {
        USCrimeArray crimeArray = new USCrimeArray();
        crimeArray.createCrimeArray();
        String[][] test = crimeArray.getCrimeArray();
        System.out.println(Arrays.deepToString(test));
    }
}