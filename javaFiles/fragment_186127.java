String input="I have worked a lot and ruined my health but I have loved my job even if "
        + "I habe been manipulated and ruined by this Photoshopped picture. "
        + "Ed and Eddy are happy today even if they have partied the whole night. ";

String output=input.replaceAll("(?<=\\w)ed\\b", "");
System.out.println(output);