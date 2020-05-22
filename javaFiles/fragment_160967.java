List<RfidTag> tags = new ArrayList<RfidTag>();

for (TagReadData tr : tagReads) 
{
    RfidTag tag = new RfidTag();

    tag.setTagId(tr.epcString());
    tag.setReadTimestamp(LocalDateTime.now());
    tag.setAntenna(tr.getAntenna());

    tags.add(tag);
}