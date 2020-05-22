String b64 = "SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t";
    try
    {
        Base64ToHex.initBase64ToIntTable();
        System.out.println(Base64ToHex.base64ToHex(b64));
        System.out.println(Base64ToHex.base64ToHexVer2(b64));

        int howManyIterations = 100000;
        Date start, stop;
        long period;

        start = new Date();
        for (int i = 0; i < howManyIterations; i++)
        {
            Base64ToHex.base64ToHexVer2(b64);
        }
        stop = new Date();
        period = stop.getTime() - start.getTime();
        System.out.println("Ver2 taken " + period + " ms");

        start = new Date();
        for (int i = 0; i < howManyIterations; i++)
        {
            Base64ToHex.base64ToHex(b64);
        }
        stop = new Date();
        period = stop.getTime() - start.getTime();
        System.out.println("Ver1 taken " + period + " ms");

    }
    catch (Exception ex)
    {
    }