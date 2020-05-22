for (i = 1; i < 17; i++) {
    int index1 = rand.nextInt(musicNotes.length);
    int index2 =  rand.nextInt(musicDuration.length);
    System.out.print(musicNotes[index1]);
    System.out.print(musicDuration[index2] + ",");
}