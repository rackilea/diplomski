while(m.find()) {
    System.out.println(m.group(1)); //will print   tag1 attr1="val1"
}

if (m.matches()) { //will evaluate the regex as ^<(.*?)>$
    System.out.println(m.group(1)); //will print    tag1 attr1="val1"><tag2></tag2></tag1
}