@Override
public void completed(final HttpResponse response) {
    try {
        teamsInSeason.put(s, new TeamsUnmarshaller().unmarshal(response.getEntity().getContent()));
    }
    catch (IllegalStateException | IOException e) {
        // TODO Auto-generated catch block
        System.out.println(e);
    } finally {
        super.completed(response);
    }
}