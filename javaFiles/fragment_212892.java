while ((inputLine = in.readLine()) != null)
 {
    System.out.println(inputLine);

    String[] strarr = inputLine.split(",");

    System.out.println("splits.size: " + strarr.length);
}