String regex = "(?=.*[aeiouy])(?!.*[aeiouy]{3})(?!.*[a-z&&[^aeiouy]]{3})(?!.*([a-z&&[^eo]])\\1).*";
System.out.println("bower".matches(regex));
System.out.println("appple".matches(regex));
System.out.println("miiixer".matches(regex));
System.out.println("hedding".matches(regex));
System.out.println("feeding".matches(regex));