class ClientDetail {
    private String description;
    private String hostname;
    private String ipaddress;
    private String hostid;
    private String file_timestamp;;
    private String software_version;
    private String commit_hash;
    // getter & setter
}

BufferedReader reader = new BufferedReader(new FileReader(new File("json.txt")));
ClientDetail data = new Gson().fromJson(reader, ClientDetail.class);