Long curr_trig = 1455213601000L;
Long last_trig = 1455213600000L;
double freq = 60.0;
if (last_trig + freq * 1000 > curr_trig) {
    System.out.println("Yup its correct");
}