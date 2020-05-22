// this will be the command which produces �jar
cmd = String.format("java –jar %s –o win -i %s -n %s -d %s -s %s", jarLocation,
          param1, param2, tgtFilePath, srcFilePath);
System.out.println(Arrays.toString(cmd.getBytes(charsetLatin1)));

// this will be the working command, as you wrote
cmd = "here you type the same command";
System.out.println(Arrays.toString(cmd.getBytes(charsetLatin1)));