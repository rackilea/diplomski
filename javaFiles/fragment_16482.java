Collection<?> itemIds =  table.getItemIds();
Item item = null;
PS_SECTION ps = null; // Declare first ps to null, because you will instantiate it later
List<PS_SECTION> newlist = new ArrayList<PS_SECTION>();
int i = 0;

             for(Object itemId : itemIds){   

                    item = table.getItem(itemId);// row
                    Long s1 = (Long) item.getItemProperty("ID").getValue();
                    String s2 = item.getItemProperty("ΕΝΟΤΗΤΑ").getValue().toString();
                    Long s3 = (Long) item.getItemProperty("ΔΙΑΤΑΞΗ").getValue();
                    Long s4 = 0L;
                    Long s5 = 0L;

                    ps = new PS_SECTION() // put it here your instantiation
                    ps.setPS_SECTION(s1);
                    ps.setNAME(s2);
                    ps.setVORDER(s3);
                    ps.setISACTIVE(s4);
                    ps.setISGLOBAL(s5);

                    newlist.add(ps);
                    i++                     
                 }