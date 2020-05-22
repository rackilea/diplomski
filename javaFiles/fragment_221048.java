public void map() throws IOException{ 
        for(int i=0; i<getVessels().size(); i++){
            if(!getVessels().get(i).getCoordinates().isEmpty()){
                FileWriter fstream = new FileWriter("C:\\Users\\Documents\\maps\\" + getVessels().get(i).getMMSI()+
                        ".kml");
                BufferedWriter out = new BufferedWriter(fstream); 
                out.write("<kml>"); 
                out.write("<Folder>");


                out.write("<Placemark>");
                out.write("<name>"+getVessels().get(i).getMMSI()+"</name>");
                out.write("<LineString>");
                out.write("<tessellate>1</tessellate>");
                out.write("<altitudeMode>clampToGround</altitudeMode>");
                out.write("<coordinates>");
                for(int j=0; j<getVessels().get(i).getCoordinates().size(); j++){
                    out.write(getVessels().get(i).getCoordinates().get(j).getLongitude()+","+
                            getVessels().get(i).getCoordinates().get(j).getLatitude());
                }
                out.write("</coordinates>");
                out.write("</LineString>");
                out.write("</Placemark>");


                for(int j=0; j<getVessels().get(i).getCoordinates().size(); j++){
                    out.write("<Placemark>");
                    out.write("<name>"+getVessels().get(i).getCoordinates().get(j).coordinates()+"</name>");
                    out.write("<tessellate>1</tessellate>");
                    out.write("<altitudeMode>clampToGround</altitudeMode>");
                    out.write("<Point>");
                    out.write("<coordinates>");
                    out.write(getVessels().get(i).getCoordinates().get(j).getLongitude()+","+
                            getVessels().get(i).getCoordinates().get(j).getLatitude());
                    out.write("</coordinates>");
                    out.write("</Point>");
                    out.write("</Placemark>");
                }

                out.write("</Folder>");
                out.write("</kml>");
                out.close();
            }
        }
    }