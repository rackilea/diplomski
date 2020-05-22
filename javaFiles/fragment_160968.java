DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
for(RfidTag tag : tags)
{
    System.out.println("Tag: " + tag.getTagId() + " "
                      + "Timestamp: " + tag.getReadTimestamp().format(formatter) + " "
                      + "Antenna: " + tag.getAntenna() ); 
}