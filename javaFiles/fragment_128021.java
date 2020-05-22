ArrayList<Dados> dadosSTA = new ArrayList<>();
ArrayList<Dados> dataForPPong = new ArrayList();

ArrayList uniqueSTA = q.getUniqueStations("localserver");

for(int i = 0; i<uniqueSTA.size(); i++)
{
    dadosSTA = q.getStationData(uniqueSTA.get(i).toString(), "localserver");
    dataForPPong = p.detectPingPongArray(5, 3, dadosSTA);
}

for(int i=0; i<dataForPPong.size(); i++)
{
    System.out.println("ID: "+dataForPPong.get(i).getId()+" STA: "+dataForPPong.get(i).getStation()
            + " PingPong: "+dataForPPong.get(i).getPingPong());
}