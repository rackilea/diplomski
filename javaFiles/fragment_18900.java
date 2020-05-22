try {
        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec("ping 192.168.0.142");

        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while ((line = input.readLine()) != null) {
            System.out.println(line);
            p.destroy();
            break;
        }
        input.close();
} catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
}