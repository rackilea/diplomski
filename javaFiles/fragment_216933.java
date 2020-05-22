BufferedWriter out = new BufferedWriter(fstream); 
                            out.write("<kml>"); 
                            out.write("<Folder>");

                            out.write("<Placemark>");
                            out.write("<name>"+entry.getKey()+"</name>");
                            out.write("<LineString>");
                            out.write("<extrude>1</extrude>"); 
                            out.write("<tessellate>1</tessellate>");
                            out.write("<altitudeMode>clampToGround</altitudeMode>");
                            out.write("<coordinates>");
                            for(int i=0; i<entry.getValue().getCoordinates().size(); i++){ //path creation 
                                out.write(entry.getValue().getCoordinates().get(i).getLongitude()+","+
                                        entry.getValue().getCoordinates().get(i).getLatitude()+" ");
                            }
                            out.write("</coordinates>");
                            out.write("</LineString>");
                            out.write("</Placemark>");

                            for(int j=0; j<entry.getValue().getCoordinates().size(); j++){ //point creation 
                                out.write("<Placemark>");
                                out.write("<name>"+entry.getValue().getCoordinates().get(j).coordinates()+"</name>");
                                out.write("<tessellate>1</tessellate>");
                                out.write("<altitudeMode>clampToGround</altitudeMode>");
                                out.write("<Point>");
                                out.write("<coordinates>");
                                out.write(entry.getValue().getCoordinates().get(j).getLongitude()+","+
                                        entry.getValue().getCoordinates().get(j).getLatitude());
                                out.write("</coordinates>");
                                out.write("</Point>");
                                out.write("</Placemark>");
                            }

                            out.write("</Folder>");
                            out.write("</kml>");
                            out.close();
                        }