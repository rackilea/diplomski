try {

        Process process = Runtime.getRuntime().exec("su");
        DataOutputStream os = new DataOutputStream(process.getOutputStream());
        String command = "date 1123104017\n";
        // Log.e("command",command);
        os.writeBytes(command);
        os.flush();
        os.writeBytes("exit\n");
        os.flush();
        process.waitFor();

    } catch (InterruptedException e) {
        Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
    } catch (IOException e) {
        Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
    }