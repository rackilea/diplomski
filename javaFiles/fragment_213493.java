String[] cmd =
        {"/bin/sh",
                "-c",
                "docker ps -q | xargs docker inspect --format '{{.HostConfig.NetworkMode}} {{ .Config.Image }} {{ .NetworkSettings.IPAddress }}'"};

Process process = Runtime.getRuntime().exec(cmd);
BufferedReader bufferedReaderObj = new BufferedReader(new InputStreamReader(process.getInputStream()));
String sLine = "";
StringBuilder output = new StringBuilder();
while ((sLine = bufferedReaderObj.readLine()) != null) {
    output.append(sLine);
}
System.out.println(output);