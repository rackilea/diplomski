while (true) {
    line = reader.readLine();

    if (line == null) {
        break;
    }

    fragmentShaderSource.append(line).append('\n');
}