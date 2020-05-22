List<APIObject[]> chunks = new ArrayList<APIObject[]>();
for (int i = 0; i < bigList.size(); i += 200) {
  APIObject[] chunk = bigList.subList(i, Math.min(bigList.size(), i + 200))
    .toArray(new APIObject[200]);
  chunks.add(chunk);
}