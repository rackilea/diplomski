List<String> nimList = new ArrayList<>();
List<String> ruangList = new ArrayList<>();
for (int i = 0; i < str_json.length(); i++) {
    JSONObject ar = str_json.getJSONObject(i);
    ruangan = ar.getString("ruang").trim();
    nimMahasiswa = ar.getString("nim").trim();
    nimList.add(nimMahasiswa);
    ruangList.add(ruangan);
}