String[] texts = new String[] {
        "Unregistered_2018-05-02_14.40.04_+621241411112_34243555523.mp3",
        "Martin_2018-04-01_03.10.40_+111_5213441935.mp3",
        "Byan_2018-01-04_04.70.01_+62994_2313325553.mp3",
};
for (String text : texts) {
    String[] split = text.split("_");
    String date  = split[1];
    String time  = split[2];
    String phone = split[3];

    System.out.println("date = " + date + ", time = " + time + ", phone = " + phone);
}