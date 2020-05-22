for (int loop = 1; loop <= trials; loop++) {  
    //select random number until 5 is selected
    do {
        randNum = randNumList.nextInt(5) + 1;
        counter++;
    } while (randNum != 5);

    outFile.println(loop + " " + randNum); //why here?? maybe you should add it below counter++;
}