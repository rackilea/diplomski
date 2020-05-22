if (userNum >= 1 && userNum <= 49) {
    lottoNumbers = lottoNumbers + userNum;
    if (i < 6) lottoNumbers = lottoNumbers + ", ";
} else {
    do {
        System.out.println("Numbers must be between 1 and 49. \nPlease try again.");
        userNum = scan.nextInt();
    } while (userNum < 1 || userNum > 49);
    // Process valid input here
    lottoNumbers = lottoNumbers + userNum;
    if (i < 6) lottoNumbers = lottoNumbers + ", ";
} // Note the extra brackets around else block