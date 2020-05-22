final MessageFormat inputFormat = new MessageFormat("{0}:{1,number,integer}:{2,number,integer}")
final String line = sc.nextLine();
//throws an exception if input is invalid - possibly catch and report
final Object[] input = inputFormat.parse(line);
final String gameName = input[0];
//will be a long
final int score = (int) input[1];
final int time = (int) input[2];