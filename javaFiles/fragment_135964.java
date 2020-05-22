if(m.find()) {
    for(int count = 1; count <= m.groupCount(); count++) {
        System.out.println("Match number " + count);
        System.out.println("start(): " + m.start(count));
        System.out.println("end(): " + m.end(count));
        System.out.println("Found value: " + m.group(count));
    }
}