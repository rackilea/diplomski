String incorrectJson = "{id: 267107086801, productCode: 02-671070868,"
            + " lastUpdate: 2018-07-15, lastUpdateTimestamp: 2018-07-15 01:49:58,"
            + " user: {pf: {document: 123456789, name: Luis Fernando},"
            + " address: {street: Rua Pref. Josu00e9 Alves Lima,number:37},"
            + " payment: [{sequential: 1, id: CREDIT_CARD, value: 188, installments: 9}]}";

    String correctJson = incorrectJson.replaceAll("(?<=: ?)(?![ \\{\\[])(.+?)(?=,|})", "\"$1\"");
    System.out.println(correctJson);