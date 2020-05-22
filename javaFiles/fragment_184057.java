List<String> deviceList = new ArrayList<String>();

BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
while ((line = input.readLine()) != null) {
    if (line.endsWith("device")) {
        deviceList.add(line.split("\\t")[0]);
    }

}

for (String device : deviceList) {
    System.out.println(device);
}