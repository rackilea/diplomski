while ((currentLine = reader.readLine()) != null) {
            currentLine = currentLine.replace(delete,"");
            if (currentLine.equals("")) {
            } else
                writer.println(currentLine);
        }