String sample = "1307%launchApp%n/a";
    String[] result = sample.split("%");
    String pass = result[0];
    String cmd = result[1];
    String additionalInfo = result[2];
    System.out.println("pass: " + pass + " CMD: " + cmd + " Addtional Info: " + additionalInfo);