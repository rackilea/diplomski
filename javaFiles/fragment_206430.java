try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stdin)))     {
    writer.write("stop in Hello.main\n");
    writer.flush();
    writer.write("run Hello");
    writer.flush();
} //writer is closed here